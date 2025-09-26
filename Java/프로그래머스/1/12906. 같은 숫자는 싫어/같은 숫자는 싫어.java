import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) stack.push(num);
        }
        
        int[] answer = stack.stream().mapToInt(Integer::intValue).toArray(); 
        return answer;
    }
}