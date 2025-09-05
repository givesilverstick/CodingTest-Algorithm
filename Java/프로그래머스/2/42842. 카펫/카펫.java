class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int width=sum-1; width>=3; width--) {
            int height = sum/width;
            if (sum%width==0 && brown==width*height-yellow && yellow==(width-2)*(height-2)) {
                answer[0] = height;
                answer[1] = width;
            }
        }
        // 노: x-2 * y-2
        // 갈: x * y - x-2 * y-2
        // 전: x * y
        return answer;
    }
}