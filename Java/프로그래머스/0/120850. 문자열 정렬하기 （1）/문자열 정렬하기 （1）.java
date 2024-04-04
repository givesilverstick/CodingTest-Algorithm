import java.util.*;
class Solution {
    public List<Integer> solution(String my_string) {
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<my_string.length(); i++) {
            int num = my_string.charAt(i);
            int asccode = num;
            if (asccode>=48 & asccode <=57) {
                answer.add(num- '0');
            }
        }
        Collections.sort(answer);
        return answer;
    }
}