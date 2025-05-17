import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본: 오름차순, peek() -> root인 가장 작은 수
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        int count = 0;
        while(pq.size() >= 2 && pq.peek() < K) {
            pq.add(cal(pq.poll(), pq.poll()));
            count++;
        }
        answer = pq.peek() >= K ? count : -1;
        return answer;
    }
    
    static int cal(int first, int second) {
        return first + second*2;
    }
}