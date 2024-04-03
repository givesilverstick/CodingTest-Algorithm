class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=1; i<=10; i++) {
            if (factorial(i) <= n) {
                answer = i;
            }
        }
        return answer;
    }
    public int factorial(int num) {
        int result = num;
        if (num>2) {
            result *= factorial(num-1);
        }
        return result;
    }
}