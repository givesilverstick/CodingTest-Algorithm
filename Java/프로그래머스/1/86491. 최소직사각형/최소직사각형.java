import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        
        for (int i=0; i<sizes.length; i++) {
            Arrays.sort(sizes[i]);
            if (width < sizes[i][0]) width = sizes[i][0];
            if (height < sizes[i][1]) height = sizes[i][1];
        }
        int answer = width * height;
        return answer;
    }
}