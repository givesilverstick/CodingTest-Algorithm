import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i=0; i< len; i++) {
            set.add(nums[i]);
        }
        if (set.size() > len/2) {
            answer = len/2;
        } else {
            answer = set.size();
        }
        return answer;
    }
}