class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int big = 0;
        for (int i=1; i<array.length; i++) {
            if (array[i] > array[big]) {
                big = i;
            }
        }
        answer[0] = array[big];
        answer[1] = big;
        return answer;
    }
}