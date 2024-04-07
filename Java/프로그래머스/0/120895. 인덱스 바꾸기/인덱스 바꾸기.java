class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char temp = my_string.charAt(num1);
        answer = my_string.substring(0, num1) + my_string.charAt(num2) + my_string.substring(num1+1);
        answer = answer.substring(0, num2) + temp + answer.substring(num2+1);
        return answer;
    }
}