import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. string으로 변환
        String[] numbers_str = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            numbers_str[i] = String.valueOf(numbers[i]);
        }
        // 2. 정렬
        Arrays.sort(numbers_str, (a,b) -> (b+a).compareTo(a+b));
        // 3. 값
        String answer = String.join("", numbers_str);
        // 4. 예외처리
        if (answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}