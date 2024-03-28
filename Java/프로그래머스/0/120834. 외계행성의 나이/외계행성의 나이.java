class Solution {
    public String solution(int age) {
        String answer = "";
        for (int i=age; i>0; i/=10) {
            answer = (char)(i%10+97) + answer;
        }
        return answer;
    }
}