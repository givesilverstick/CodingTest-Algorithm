import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> runQ = new ArrayDeque<>();   // 실행 대기 큐
        Queue<Integer> idxQ = new ArrayDeque<>();   // 인덱스 저장
        int maxPrior = 0;
        for (int i=0; i<priorities.length; i++) {
            runQ.offer(priorities[i]);
            idxQ.offer(i);
            maxPrior = Math.max(maxPrior, priorities[i]);
        }
        
        int answer = 0;
        while (!runQ.isEmpty()) {
            int cur = runQ.poll();
            int idx = idxQ.poll();
            
            boolean isPrior = true;
            
            for (int i=cur+1; i<=maxPrior; i++) {
                if (runQ.contains(i)) {
                    isPrior = false;
                    break;
                }
            }
            
            if (isPrior) {
                answer++;
                if (idx==location) return answer;
            } else {
                runQ.offer(cur);
                idxQ.offer(idx);
            }
        }
        return answer;
    }
}