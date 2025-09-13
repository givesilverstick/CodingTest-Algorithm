import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answerList = new ArrayList<>();
        while (n != 1) {
            answerList.add(n);
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        if (n==1) answerList.add(n);
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray(); // 외우기
        return answer;
    }
}