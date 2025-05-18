import java.util.*;
class Solution {
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        
        return count;
    }
    
    static void dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) count++;
            return;
        }
        dfs(numbers, depth+1, sum+numbers[depth], target);
        dfs(numbers, depth+1, sum-numbers[depth], target);
    }
}