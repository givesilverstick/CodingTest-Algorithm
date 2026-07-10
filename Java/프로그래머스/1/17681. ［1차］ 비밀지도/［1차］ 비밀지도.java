import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        // 2진수로 변경
        int[][] bMap = new int[n][n];
        for (int i=0; i<n; i++) {
            int num1 = arr1[i];
            int num2 = arr2[i];
            for (int j=n-1; j>=0; j--, num1/=2, num2/=2) {
                bMap[i][j] = Math.max(num1%2, num2%2);
            }
        }
        
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            String str = "";
            for (int j=0; j<n; j++) {
                if (bMap[i][j] == 1) str += "#";
                else str += " ";
            }
            answer[i] = str;
        }
        return answer;
    }
}