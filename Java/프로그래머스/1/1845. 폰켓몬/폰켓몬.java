import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        HashSet<Integer> kind = new HashSet<>();
        
        for (int num : nums) {
            kind.add(num);
        }
        
        if (kind.size() < nums.length/2) answer = kind.size();
        return answer;
    }
}