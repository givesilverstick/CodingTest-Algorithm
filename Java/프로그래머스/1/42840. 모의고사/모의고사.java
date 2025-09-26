import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        int[] score = new int[3];
        // pattern
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == p1[i%p1.length]) score[0]++;
            if (answers[i] == p2[i%p2.length]) score[1]++;
            if (answers[i] == p3[i%p3.length]) score[2]++;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i=0; i<score.length; i++) {
            if (score[i] > max) max = score[i];
        }
        
        for (int i=0; i<score.length; i++) {
            if (score[i] == max) answerList.add(i+1);
        }
        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}