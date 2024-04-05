class Solution {
    public int solution(int[] sides) {
        int answer = 2;
        int temp;
        for (int i=0; i<sides.length; i++) {
            for (int j=i+1; j<sides.length; j++) {
                if (sides[i] > sides[j]) {
                    temp = sides[i];
                    sides[i] = sides[j];
                    sides[j] = temp;
                }
            }
        }
        if (sides[2] < sides[0]+sides[1]) {
            answer = 1;
        }
        return answer;
    }
}