import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0][0] = true;
        distance[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i=0; i<dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx][ny]==1) {
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[cur[0]][cur[1]]+1;
                }
            }
        }
        if (visited[n-1][m-1]) answer = distance[n-1][m-1];
        
        return answer;
    }
    void bfs() {
        
    }
}