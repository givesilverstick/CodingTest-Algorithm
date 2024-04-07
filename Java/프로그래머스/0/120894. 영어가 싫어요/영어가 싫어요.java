class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int idx = 0;
        for (int i=2; i<=numbers.length(); i++) {
            for (int j=0; j<num.length; j++) {
                if (numbers.substring(idx, i).equals(num[j])) {
                    answer = answer*10 + j;
                    idx = i;
                }
            }
        }
        return answer;
    }
}