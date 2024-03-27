class Solution {
    public int[] solution(int n) {
        int num;
        if (n%2==0) {
            num = n/2;
        } else {
            num = n/2 + 1;
        }
        int[] answer = new int[num];
        int idx = 0;
        for (int i=1; i<=n; i+=2, idx++) {
            answer[idx] = i;
        }
        return answer;
    }
}