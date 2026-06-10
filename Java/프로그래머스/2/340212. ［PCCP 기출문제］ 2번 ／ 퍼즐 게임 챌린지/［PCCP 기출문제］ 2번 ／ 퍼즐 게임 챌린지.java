class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        /*
        -----------------------
        diffs : 퍼즐의 난이도
        times : 퍼즐의 소요 시간
        limit : 전체 제한 시간
        -----------------------
        숙련도에 따라 틀리는 횟수 다름.
        -> (diff-level)번 틀림
                한 번 틀릴 때 마다 (time_cur+time_prev) 시간 사용
            + 푸는 시간 time_cur
        => 총 사용 시간 : (diff-level)*(time_cur+time_prev) + time_cur
        */
        int n = diffs.length;   // 퍼즐의 개수
        
        int left = 1;
        int right = 0;
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }
        int answer = right; // 숙련도의 최소값 (제한시간 limit 내에 퍼즐 모두 해결)
        
        while (left <= right) {
            int mid = (left+right)/2;
            if (canSolve(diffs, times, limit, mid)) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return answer;
    }
    
    boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        int n = diffs.length;   // 퍼즐의 개수
        long totalTime = 0;
        int time_prev = 0;  // 이전 퍼즐의 소요 시간
        for (int i=0; i<n; i++) {
            int diff = diffs[i];   // 현재 퍼즐의 난이도
            int time_cur = times[i];   // 현재 퍼즐의 소요 시간
            int wrongCnt = diff>level ? diff-level : 0;
            totalTime += (long) wrongCnt*(time_cur+time_prev) + time_cur;
            time_prev = time_cur;
            if (totalTime > limit) return false;
        }
        if (totalTime <= limit) return true;
        return false;
    }
}