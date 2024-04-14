class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int i=0; i<array.length; i++) {
            for (int j=array[i]; j>0; j/=10) {
                if (j%10 == 7) {
                    answer++;
                }
            }
        }
        return answer;
    }
}