class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i=0; i<my_string.length(); i++) {
            int asccode = my_string.charAt(i) - '0';
            if (asccode>=0 & asccode<=9) {
                answer += asccode;
            }
        }
        return answer;
    }
}