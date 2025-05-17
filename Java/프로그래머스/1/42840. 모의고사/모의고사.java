import java.util.*; 

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern_1 = {1, 2, 3, 4, 5};
        int[] pattern_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == pattern_1[i%pattern_1.length]) {
                scores[0]++;
            }
            if (answers[i] == pattern_2[i%pattern_2.length]) {
                scores[1]++;
            }
            if (answers[i] == pattern_3[i%pattern_3.length]) {
                scores[2]++;
            }
        }
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (scores[i]==max) {
                result.add(i+1);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}