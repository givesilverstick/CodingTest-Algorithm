class Solution {
    public int solution(int order) {
        int answer = 0;
        for (int i=order; i>0; i/=10) {
            if (i%10==3 | i%10==6 | i%10==9) {
                answer++;
            }
        }
        return answer;
    }
}