import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        // 비트마스킹 연습
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            int merged = arr1[i] | arr2[i];
            
            for (int j=n-1; j>=0; j--) {
                if ((merged & (1<<j)) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}