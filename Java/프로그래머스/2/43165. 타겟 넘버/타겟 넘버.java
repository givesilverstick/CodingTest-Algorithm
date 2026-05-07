class Solution {
    static int nums[], answer, t;
    public int solution(int[] numbers, int target) {
        answer = 0;
        nums = numbers;
        t = target;
        dfs(0,0);
        return answer;
    }
    void dfs(int cnt, int sum) {
        if (cnt==nums.length) {
            if (sum == t) answer++;
            return;
        }
        
        dfs(cnt+1, sum+nums[cnt]);
        dfs(cnt+1, sum-nums[cnt]);
    }
}