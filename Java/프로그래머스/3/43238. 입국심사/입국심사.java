import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long left = 1; // 최소 1분
        long right = (long) Arrays.stream(times).max().getAsInt() * n; // 최대 시간
        long answer = right;
            
        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            
            for (int time : times) {
                total += mid / time; // mid 시간 동안 몇 명 심사 가능한지
            }
            
            if (total >= n) { // 시간 충분한 경우
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}