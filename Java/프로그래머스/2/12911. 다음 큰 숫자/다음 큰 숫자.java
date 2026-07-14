class Solution {
    public int solution(int n) {
        int answer = n+1;
        // 2진수에서 1의 개수 세는 메서드 : bitCount()
        while (Integer.bitCount(n) != Integer.bitCount(answer)) {
            answer++;
        }
        return answer;
    }
}