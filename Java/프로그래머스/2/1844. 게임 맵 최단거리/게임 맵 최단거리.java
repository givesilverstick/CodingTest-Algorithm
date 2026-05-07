import java.util.*;

class Solution {
    // dfs는 효율성 테스트에서 시간초과.
    static final int INF = Integer.MAX_VALUE;
    static int[] dr={-1,1,0,0}, dc={0,0,-1,1};
    static int answer, Map[][], n, m;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        answer = INF;
        Map = maps;
        n = Map.length;
        m = Map[0].length;
        visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0, 1});    // r,c cnt
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            
            if (r==n-1 && c==m-1) {
                answer = Math.min(answer, cnt);
                break;
            }
            
            for (int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if (nr<0 || nr>=n || nc<0 || nc>=m || visited[nr][nc]) continue;
                if (maps[nr][nc]==1) {
                    q.offer(new int[] {nr,nc, cnt+1});
                    visited[nr][nc] = true;
                }
            }
            
        }
        return answer==INF ? -1 : answer;
    }
}