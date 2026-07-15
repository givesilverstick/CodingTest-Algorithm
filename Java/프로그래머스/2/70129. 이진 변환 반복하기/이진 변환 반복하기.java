class Solution {
    public int[] solution(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        while (!s.equals("1")) {
            int oneCnt = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCnt++;
                } else {
                    cnt2++;
                }
            }
            s = Integer.toBinaryString(oneCnt); // 2진수로 변환하는 메서드 있음
            cnt1++;
        }
        int[] answer = new int[2];
        answer[0] = cnt1;
        answer[1] = cnt2;
        return answer;
    }
}