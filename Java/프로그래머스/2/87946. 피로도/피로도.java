import java.util.*;

class Solution {
    int maxCount = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return maxCount;
    }
    
    void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        boolean canGo = false;
        for (int i=0; i<dungeons.length; i++) {
            if (k>=dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false; // backtracking
                canGo = true;
            }
        }
        
        if (!canGo) {
            maxCount = Math.max(maxCount, count);
        }
    }
}