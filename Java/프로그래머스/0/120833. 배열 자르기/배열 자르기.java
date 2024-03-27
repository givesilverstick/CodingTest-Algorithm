class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        int i = 0;
        for (int num=num1; num<=num2; num++) {
            answer[i++] = numbers[num];
        }
        return answer;
    }
}