import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for (int[] s : sizes) {
            Arrays.sort(s);
        }
        int width = Integer.MIN_VALUE, height = Integer.MIN_VALUE;
        
        for (int[] s : sizes) {
            if (s[0] > width) width = s[0];
            if (s[1] > height) height = s[1];
        }
        answer = width * height;
        return answer;
    }
}