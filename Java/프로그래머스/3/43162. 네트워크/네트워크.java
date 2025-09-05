class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] computers, boolean[] visited, int depth) {
        visited[depth] = true;
        for (int i=0; i<computers.length; i++) {
            if (!visited[i] && computers[i][depth]==1) {
                dfs(computers, visited, i);
            }
        }
    }
}