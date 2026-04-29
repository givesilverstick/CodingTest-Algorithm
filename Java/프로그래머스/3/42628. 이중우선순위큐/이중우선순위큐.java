import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        for (String oper : operations) {
            String[] operSplit = oper.split(" ");
            switch (operSplit[0]) {
                case "I": 
                    // pq.offer(new MinVertex(Integer.parseInt(operSplit[1])));
                    minpq.offer(Integer.parseInt(operSplit[1]));
                    maxpq.offer(Integer.parseInt(operSplit[1]));
                    break;
                case "D":
                    if (minpq.isEmpty()) continue;
                    if (Integer.parseInt(operSplit[1]) == 1) {
                        int max = maxpq.poll();
                        minpq.remove(max);
                    } else {
                        int min = minpq.poll();
                        maxpq.remove(min);
                    }
                    break;
            }
            
        }
        answer[0] = maxpq.isEmpty() ? 0 : maxpq.peek();
        answer[1] = minpq.isEmpty() ? 0 : minpq.peek();
        return answer;
    }
}