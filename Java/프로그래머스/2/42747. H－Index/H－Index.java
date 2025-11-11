import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = n;
        boolean isMax = false;
        Arrays.sort(citations);
        System.out.println(citations[n-1]);
        while (!isMax) {
            int count = 0;
            for (int i=n-1; i>=0; i--) {
                if (citations[i] >= answer) count++;
                if (count >= answer) {
                    isMax = true;
                    break;
                }
            }
            if (count < answer) answer--;
        }
        return answer;
    }
}