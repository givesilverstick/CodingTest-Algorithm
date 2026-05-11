import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int length = people.length;
        int s = 0;
        int e = people.length-1;
        while (s < e) {
            int sum = people[s]+people[e];
            if (sum > limit) e--;
            else {
                answer++;
                s++;
                e--;
                length -= 2;
            }
        }
        return answer+length;
    }
}