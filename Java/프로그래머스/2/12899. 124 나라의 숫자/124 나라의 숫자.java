class Solution {
    public String solution(int n) {
        String[] nums = {"1", "2", "4"};
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int r = n % 3;
            if (r == 0) {
                sb.append(nums[2]);
                n = n / 3 - 1;
            } else {
                sb.append(nums[r-1]);
                n = n / 3;
            }
            
        }
        return sb.reverse().toString();
    }
}