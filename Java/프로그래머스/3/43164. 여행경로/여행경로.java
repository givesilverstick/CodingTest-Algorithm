import java.util.*;

class Solution {
    List<String> answerList = new ArrayList<>();
    boolean finished = false;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        boolean[] visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a,b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        List<String> target = new ArrayList<>();
        target.add("ICN");
        dfs(tickets, visited, target);
        
        answer = answerList.toArray(new String[0]);
        
        return answer;
    }
    
    void dfs(String[][] tickets, boolean[] visited, List<String> target) {
        if (finished) return;
        if (target.size() == tickets.length+1) {
            answerList = new ArrayList<>(target);
            finished = true;
            return; 
        }
        for (int i=0; i<tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(target.get(target.size()-1))) {
                visited[i] = true;
                target.add(tickets[i][1]);
                dfs(tickets, visited, target);
                visited[i] = false;
                target.remove(target.size()-1);
            }
        }
    }
}