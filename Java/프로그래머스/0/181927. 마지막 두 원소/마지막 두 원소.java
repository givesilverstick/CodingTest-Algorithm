class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        for (int i=0; i<num_list.length; i++) {
            answer[i] = num_list[i];
        }
        int diff = num_list[num_list.length-1] - num_list[num_list.length-2];
        if (diff > 0) {
            answer[num_list.length] = diff;
        } else {
            answer[num_list.length] = num_list[num_list.length-1]*2;
        }
        return answer;
    }
}