class Solution {
    public int[] solution(int[] emergency) {
        int[] sorted = new int[emergency.length];
        int[] answer = new int[emergency.length];
        for (int i=0; i<emergency.length; i++) {
            sorted[i] = emergency[i];
        }
        for (int i=0; i<sorted.length; i++) {
            for (int j=i+1; j<sorted.length; j++) {
                if (sorted[j] > sorted[i]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[i];
                    sorted[i] = temp;
                }
            }
        }
        for (int i=0; i<sorted.length; i++) {
            for (int j=0; j<emergency.length; j++) {
                if (sorted[i] == emergency[j]) {
                    answer[j] = i+1;
                }
            }
        }
        return answer;
    }
}