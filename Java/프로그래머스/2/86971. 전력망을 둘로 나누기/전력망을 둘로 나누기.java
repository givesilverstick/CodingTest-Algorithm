import java.util.*;

class Solution {
    
    static int N, adj[][];
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N = n;
        
        /*
        V : n개
        E : n-1개
        */
        
        adj = new int[n+1][n+1];
        
        for (int i=0; i<n-1; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        
        
        // E 만큼 각 하나씩 없애서, 전력 개수 세기
        for (int i=0; i<n-1; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            // 먼저 끊기
            adj[a][b] = 0;
            adj[b][a] = 0;
                
            // 전력 개수 세기
            answer = Math.min(answer, count());
                
            // 복구
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        
        return answer;
    }
    
    public int count() {
        int cnt1 = 0;
        int cnt2 = 0;
        visited = new boolean[N+1];
        
        // bfs로 개수 카운트
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                cnt1 = bfs(i, 1);
                break;
            }
        }
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                cnt2 = bfs(i, 1);
                break;
            }
        }
        
        return Math.abs(cnt1-cnt2);
    }
    
    public int bfs(int idx, int cnt) {
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(idx);
        visited[idx] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i=1; i<=N; i++) {
                if (cur==i || visited[i]) continue;
                if (adj[cur][i]==1) {
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}