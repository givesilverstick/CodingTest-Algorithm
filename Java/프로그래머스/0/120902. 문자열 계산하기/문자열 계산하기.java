class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] tokens = my_string.split(" ");

        answer = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);

            if (operator.equals("+")) {
                answer += operand;
            } else if (operator.equals("-")) {
                answer -= operand;
            }
        }
        return answer;
    }
}