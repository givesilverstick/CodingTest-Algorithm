class Solution {
    public int solution(int[] array, int n) {
        for (int i=0; i<array.length; i++) {
            array[i] -= n;
        }
        int answer = array[0];
        for (int i=1; i<array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(answer)) {
                answer = array[i];
            } else if (Math.abs(array[i])==Math.abs(answer) & array[i]<answer) {
                answer = array[i];
            }
        }
        answer += n;
        return answer;
    }
}