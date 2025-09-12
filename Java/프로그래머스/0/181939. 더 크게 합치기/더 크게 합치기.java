class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String ab = a + "" + b; 
        String ba = b + "" + a;
        for (int i=0; i<2; i++) {
            if (answer < Integer.parseInt(ab)) {
                answer = Integer.parseInt(ab);
            } else if (answer < Integer.parseInt(ba)) {
                answer = Integer.parseInt(ba);
            }
        }
        return answer;
    }
}