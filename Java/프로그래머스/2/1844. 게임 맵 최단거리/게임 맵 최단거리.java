import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    class Location {
        int x;
        int y;
        int distance;
        
        Location(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Location> queue = new LinkedList<>();
        
        // 시작 위치
        queue.offer(new Location(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            // 현재 위치
            Location current = queue.poll();
            
            // 도달 시
            if (current.x == n-1 && current.y == m-1) {
                return current.distance;
            }
            
            // 도달 안 한 경우
            for (int d=0; d<4; d++) {
                int mx = current.x + dx[d];
                int my = current.y + dy[d];
                
                if (mx>=0 && my>=0 && mx<n && my<m && maps[mx][my]==1 && !visited[mx][my]) {
                    visited[mx][my] = true;
                    queue.offer(new Location(mx, my, current.distance+1));
                }
            }
        }
        
        return -1;
    }
}