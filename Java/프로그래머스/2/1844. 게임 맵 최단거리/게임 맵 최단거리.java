import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    class CoorD {
        int x;
        int y;
        int d;
        
        CoorD(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length; // row
        int m = maps[0].length; // col
        
        Queue<CoorD> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new CoorD(0,0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            CoorD current = queue.poll();
            
            // 도달 O
            if (current.x == n-1 && current.y == m-1) return current.d;
            
            // 도달 X
            for (int d=0; d<4; d++) {
                int mx = current.x + dx[d];
                int my = current.y + dy[d];
                
                if (mx>=0 && my>=0 && mx<n && my<m && maps[mx][my]==1 && !visited[mx][my]) {
                    queue.offer(new CoorD(mx,my, current.d+1));
                    visited[mx][my] = true;
                }
            }
        }
        return -1;
    }
}