import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] score = new int[3];
        int[] pattern_stu1 = {1,2,3,4,5};
        int[] pattern_stu2 = {2,1,2,3,2,4,2,5};
        int[] pattern_stu3 = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == pattern_stu1[i%pattern_stu1.length]) score[0]++;
            if (answers[i] == pattern_stu2[i%pattern_stu2.length]) score[1]++;
            if (answers[i] == pattern_stu3[i%pattern_stu3.length]) score[2]++;
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        List<Integer> answerList = new ArrayList<>();
        for (int i=0; i<score.length; i++) {
            if (score[i]==maxScore) answerList.add(i+1);
        }
        System.out.println(answerList);
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}