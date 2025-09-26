import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        for (int[] size : sizes){
            Arrays.sort(size);
        }
        int w = Integer.MIN_VALUE;
        int h = Integer.MIN_VALUE;
        
        for (int[] size : sizes) {
            if (size[0] > w) w = size[0];
            if (size[1] > h) h = size[1];
        }
        int answer = w * h;
        return answer;
    }
}