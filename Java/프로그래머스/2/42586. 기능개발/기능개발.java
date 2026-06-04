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
        Map<Integer, Integer> map = new TreeMap<>();    // day, count
        for (int i=0; i<n; i++) {
            int day = (100-progresses[i])/speeds[i];
            if ((100-progresses[i])%speeds[i] > 0) {
                day++;
            }
            
            processTime[i] = day;
            if (i!=0 && processTime[i-1] > processTime[i]) {
                processTime[i] = processTime[i-1];
            }
            map.put(processTime[i], map.getOrDefault(processTime[i], 0)+1);
        }
        
        int[] answer = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            answer[i++] = map.get(key);
        }
        return answer;
    }
}