class Solution {
    public String[] solution(String my_str, int n) {
        int num = (int)Math.ceil((double)my_str.length()/(double)n);
        String[] answer = new String[num];
        int idx = 0;
        for (int i=0; i<num-1; i++) {
            answer[i] = my_str.substring(idx,idx+n);
            idx += n;
        }
        answer[num-1] = my_str.substring(idx);
        return answer;
    }
}