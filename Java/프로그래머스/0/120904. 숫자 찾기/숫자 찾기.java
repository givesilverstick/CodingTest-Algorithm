class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        int count = 0;
        int idx = -1;
        for (int i=num; i>0; i/=10) {
            if (i%10 == k) {
                idx = count;
            }
            count++;
        }
        if (idx != -1) {
            answer = count - idx;
        }
        return answer;
    }
}