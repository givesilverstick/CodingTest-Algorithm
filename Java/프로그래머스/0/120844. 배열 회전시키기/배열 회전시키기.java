class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = numbers;
        int num = 1;
        int temp;
        if (direction.equals("left")) {
            num = numbers.length-1;
        }
        System.out.println(num);
        for (int i=0; i<num; i++) {
            temp = answer[numbers.length-1];
            for (int j=numbers.length-1; j>0; j--) {
                answer[j] = answer[j-1];
            }
            answer[0] = temp;
        }
        return answer;
    }
}