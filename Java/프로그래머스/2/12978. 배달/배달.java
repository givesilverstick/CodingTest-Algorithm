import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        /*
        N : 마을 개수 (1~N 번)
        road : 도로 정보 (a,b : 연결된 두 마을 번호, c : 통행 시간)
        K : 배달 가능 시간
        
        1번 마을 -> 배달 가능 마을 번호 개수 ? -> 1번~?번까지 최소 시간 찾고 K와 비교
        */
        
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        Arrays.fill(dist, INF);
        dist[1] = 0;    // 출발점
        
        int[][] adj = new int[N+1][N+1];
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];

            if (adj[a][b] == 0 || adj[a][b] > c) {
                adj[a][b] = c;
                adj[b][a] = c;
            }
        }
                
        for (int i=1; i<=N; i++) {
            int minIdx = -1;
            int minDist = INF;
            
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minIdx = j;
                }
            }
            
            visited[minIdx] = true;
            for (int j=1; j<=N; j++) {
                if (!visited[j] && adj[minIdx][j]!=0) {
                    dist[j] = Math.min(dist[j], dist[minIdx]+adj[minIdx][j]);
                }
            }
        }
        
        int answer = 0;
        
        for (int i=1; i<=N; i++) {
            if (dist[i]<=K) answer++;
        }

        return answer;
    }
}