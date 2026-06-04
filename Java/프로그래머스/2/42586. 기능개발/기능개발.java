import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /*
        (작업 : 먼저 배포되어야 하는 순서)
        progresses : 작업 진도량
        speeds : 하루 작업 속도
        */
        int n = progresses.length;  // 작업 수
        int[] processTime = new int[n]; // 완료하는데 걸리는 시간
        List<Integer> answerList = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            int day = (100-progresses[i])/speeds[i];
            if ((100-progresses[i])%speeds[i] > 0) {
                day++;
            }
            
            processTime[i] = day;
            if (i!=0 && processTime[i-1] >= processTime[i]) {
                processTime[i] = processTime[i-1];
                int idx = answerList.size()-1;
                int count = answerList.get(idx);
                answerList.set(idx, count+1);
            } else {
                answerList.add(1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) answer[i] = answerList.get(i);
        return answer;
    }
}