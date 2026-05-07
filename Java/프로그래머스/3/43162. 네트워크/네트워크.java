class Solution {
    static int N, comps[][];
    static boolean[] checked;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        comps = computers;
        checked = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!checked[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int idx) {
        checked[idx] = true;
        
        for (int i=0; i<N; i++) {
            if (idx!=i && !checked[i] && comps[idx][i]==1) dfs(i);
        }
    }
}