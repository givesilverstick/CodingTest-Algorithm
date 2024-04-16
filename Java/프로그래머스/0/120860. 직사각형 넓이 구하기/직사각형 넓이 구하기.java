class Solution {
    public int solution(int[][] dots) {
        int answer = 1;
        for (int i=1; i<dots.length; i++) {
            if (dots[0][0] == dots[i][0]) {
                answer *= Math.abs(dots[0][1] - dots[i][1]);
            }
            if (dots[0][1] == dots[i][1]) {
                answer *= Math.abs(dots[0][0] - dots[i][0]);
            }
        }
        return answer;
    }
}