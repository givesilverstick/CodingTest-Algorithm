import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = -1; // 최단 거리
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>(); // r,c, count
        boolean[][] visited = new boolean[n][m];
        
        q.offer(new int[] {0,0, 1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0]==n-1 && cur[1]==m-1) {
                return cur[2];
            }
            for (int d=0; d<4; d++) {
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];
                
                if (nr<0 || nr>=n || nc<0 || nc>=m || visited[nr][nc]) continue;
                
                if (maps[nr][nc]==1) {
                    q.offer(new int[] {nr,nc, cur[2]+1});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return answer;
    }
}