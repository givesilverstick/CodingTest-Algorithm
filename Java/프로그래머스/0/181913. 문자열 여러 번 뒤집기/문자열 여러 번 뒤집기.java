class Solution {
    public String solution(String my_string, int[][] queries) {
        
        for (int[] query : queries) {
            StringBuilder slice = new StringBuilder(my_string.substring(query[0], query[1]+1));
            String reverse = slice.reverse().toString();
            if (query[0] == 0) {
                my_string = reverse + my_string.substring(query[1]+1, my_string.length());
            } else if (query[1] == my_string.length()) {
                my_string = my_string.substring(0, query[0]) + reverse;
            } else {
                my_string = my_string.substring(0, query[0]) + reverse + my_string.substring(query[1]+1, my_string.length());
            }
        }
        String answer = my_string;
        return answer;
    }
}