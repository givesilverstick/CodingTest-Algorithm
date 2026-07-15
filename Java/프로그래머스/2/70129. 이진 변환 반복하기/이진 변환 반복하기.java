class Solution {
    public int[] solution(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sb.append('1');
                } else {
                    cnt2++;
                }
            }
            s = toBinaryNum(sb.length());
            cnt1++;
        }
        int[] answer = new int[2];
        answer[0] = cnt1;
        answer[1] = cnt2;
        return answer;
    }
    
    String toBinaryNum(int len) {
        String str = "";
        for (int i=len; i>0; i/=2) {
            str = i%2 + str;
        }
        return str;
    }
}