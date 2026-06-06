class Solution {
    static int answer = 0; // 타겟 넘버를 만드는 방법의 수
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(numbers, target, idx+1, sum+numbers[idx]);  // 더하기
        dfs(numbers, target, idx+1, sum-numbers[idx]);  // 빼기
    }
}