import java.util.*;

class Solution {
    static int n;
    static String answer[], Tickets[][];
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        Tickets = tickets;
        n = tickets.length;
        visited = new boolean[n];
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        
        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs(0, "ICN", list);
        return answer;
    }
    
    boolean dfs(int cnt, String target, List<String> answerList) {
        if (cnt == n) {
            answer = answerList.toArray(new String[0]);
            return true;
        }
        
        for (int i=0; i<n; i++) {
            if (!visited[i] && Tickets[i][0].equals(target)) {
                answerList.add(Tickets[i][1]);
                visited[i] = true;
                if (dfs(cnt+1, Tickets[i][1], answerList)) return true;
                answerList.remove(answerList.size()-1);
                visited[i] = false;
            }
        }
        return false;
    }
}