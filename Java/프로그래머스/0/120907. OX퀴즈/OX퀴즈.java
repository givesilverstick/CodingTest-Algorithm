class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i=0; i<quiz.length; i++) {
            String[] temp = quiz[i].split(" ");
            int result = Integer.parseInt(temp[0]);
            for (int j=1; j<temp.length; j++) {
                if (temp[j].equals("-")) {
                    result -= Integer.parseInt(temp[j+1]);
                } else if (temp[j].equals("+")) {
                    result += Integer.parseInt(temp[j+1]);
                } else if (temp[j].equals("=")) {
                    if (result == Integer.parseInt(temp[j+1])) {
                        answer[i] = "O";
                    } else {
                        answer[i] = "X";
                    }
                }
            }
        }
        return answer;
    }
}