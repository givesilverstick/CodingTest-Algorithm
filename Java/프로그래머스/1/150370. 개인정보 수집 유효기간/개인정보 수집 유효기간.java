import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }
        
        for (int i=0; i<privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            // 날짜
            String date = split[0];
            String kind = split[1];
            int term = termMap.get(kind);
            
            if (isDestruction(today, date, term)) {
                answerList.add(i+1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) answer[i] = answerList.get(i); 
        return answer;  // 파기해야 할 개인정보 번호
    }
    
    boolean isDestruction(String todayStr, String dateStr, int term) {
        int[] today = toDate(todayStr);
        int[] date = toDate(dateStr);
        
        // 기간 더하기
        int todaySum = today[0]*12*28 + today[1]*28 + today[2];
        int dateSum = date[0]*12*28 + date[1]*28 + date[2] + term*28;
        if (todaySum >= dateSum) return true;
        
        return false;
    }
    
    int[] toDate(String dateStr) {
        String[] dateStrArr = dateStr.split("\\.");
        int[] date = new int[3];
        for (int i=0; i<3; i++) date[i] = Integer.parseInt(dateStrArr[i]);
        return date;
    }
    
    
}