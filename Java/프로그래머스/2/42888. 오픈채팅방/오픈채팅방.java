import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> user = new HashMap<>(); // UUID, NickName
        List<String> log1 = new ArrayList<>();  // 입장 기록
        List<String> log2 = new ArrayList<>();  // UUID 기록
        
        for (String r : record) {
            String[] split = r.split(" ");
            if (split[0].equals("Enter") || split[0].equals("Change")) user.put(split[1], split[2]);
            if (!split[0].equals("Change")) {
                log1.add(split[0]);
                log2.add(split[1]);
            }
            
        }
        
        String[] answer = new String[log1.size()];
        for (int i=0; i<log1.size(); i++) {
            answer[i] = user.get(log2.get(i));
            if (log1.get(i).equals("Enter")) answer[i] += "님이 들어왔습니다.";
            else answer[i] += "님이 나갔습니다.";
        }
        return answer;
    }
}