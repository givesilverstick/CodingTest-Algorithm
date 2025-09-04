import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        
        String[] arr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        
        for (String num : arr) {
            answer += num;
        }
        
        if (arr[0].equals("0")) {
            answer = "0";
        }
        return answer;
    }
}