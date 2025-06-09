import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();
        int previous = -1;
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != previous) {
                answerList.add(arr[i]);
            }
            previous = arr[i];
        }
        
        
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        

        return answer;
    }
}