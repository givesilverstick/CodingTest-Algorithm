import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = 0;
            visited[p[1]][p[0]] = true;
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (i==1 && j==1) dp[i][j] = 1;
                else if (!visited[i][j]) {
                    int top = (i==1) ? 0 : dp[i-1][j];
                    int left = (j==1) ? 0 : dp[i][j-1];
                    dp[i][j] = (top+left) % 1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}