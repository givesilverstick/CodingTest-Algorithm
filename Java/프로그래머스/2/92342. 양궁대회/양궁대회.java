import java.util.*;

class Solution {
    static int[] Info;
    static int diff;
    static int[] Answer;
    public int[] solution(int n, int[] info) {
        Info = info;
        diff = 0;   // 최대값
        Answer = new int[info.length];
        
        dfs(0, 0, 0, n, new int[info.length]);
        if (diff == 0) return new int[] {-1};
        
        return Answer;
    }
    
    void dfs(int idx, int sum1, int sum2, int arrowsLeft, int[] answer) {
        if (idx == 11) {
            int scoreDiff = sum2-sum1;
            if (scoreDiff <= 0) return;
            
            int[] result = answer.clone();
            // 남은 화살은 0점에 몰아주기
            if (arrowsLeft > 0) {
                result[10] += arrowsLeft;
            }
            if (diff < scoreDiff) {
                diff = scoreDiff;
                Answer = result;
            } else if (diff == scoreDiff && isBetter(result, Answer)) {
                Answer = result;
            }
            return;
        }
        
        // 라이언 승
        if (arrowsLeft > Info[idx]) {
            answer[idx] = Info[idx]+1;
            dfs(idx+1, sum1, sum2+(10-idx), arrowsLeft-(Info[idx]+1), answer);
            answer[idx] = 0;
        }
        
        // 어피치 승
        if (Info[idx]>0) {
            dfs(idx+1, sum1+(10-idx), sum2, arrowsLeft, answer);
        } else {
            dfs(idx+1, sum1, sum2, arrowsLeft, answer);
        }
    }
    
    // 이 메서드 다시 풀기
    boolean isBetter(int[] now, int[] prev) {
        // 낮은 점수에 화살이 더 많은 경우 우선
        for (int i = 10; i >= 0; i--) {
            if (now[i] > prev[i]) return true;
            if (now[i] < prev[i]) return false;
        }

        return false;
    }
}