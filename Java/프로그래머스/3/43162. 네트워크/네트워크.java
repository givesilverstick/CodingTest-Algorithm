class Solution {
    static boolean[] checked;
    static int N, adj[][];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        checked = new boolean[n];
        N = n;
        adj = computers;
        for (int i=0; i<n; i++) {
            if (!checked[i]) {
                search(i);
                answer++;
            }
        }
        return answer;
    }
    
    void search(int idx) {
        checked[idx] = true;
        for (int i=0; i<N; i++) {
            if (idx!=i && !checked[i] && adj[idx][i]==1) {
                search(i);
            }
        }
    }
}