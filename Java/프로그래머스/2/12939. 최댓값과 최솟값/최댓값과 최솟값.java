class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String str : parts) {
            int num = Integer.parseInt(str);
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        
        String answer = min + " " + max;
        return answer;
    }
}