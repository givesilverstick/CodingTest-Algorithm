import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> inRecord = new HashMap<>();    // 차번호, IN 시간
        Map<String, Integer> timeMap = new TreeMap<>();  // 차번호, 총 시간
        for (String record : records) {
            String[] split = record.split(" ");
            String[] timeStr = split[0].split(":");
            int time = toMinutes(timeStr);
            if (split[2].equals("IN")) {
                inRecord.put(split[1], time);
            }
            else if (split[2].equals("OUT")) {
                int totalTime = timeMap.getOrDefault(split[1], 0);
                timeMap.put(split[1], totalTime + time-inRecord.get(split[1]));
                inRecord.remove(split[1]);
            }
        }
        for (String key : inRecord.keySet()) {
            int endTime = 23*60 + 59;
            int totalTime = timeMap.getOrDefault(key, 0);
            timeMap.put(key, totalTime + endTime-inRecord.get(key));
            // inRecord.remove(key);
        }
        
        int[] answer = new int[timeMap.size()];
        int idx = 0;
        for (String key : timeMap.keySet()) {
            int time = timeMap.get(key) - fees[0];
            // 기본 요금 더하기
            answer[idx] = fees[1];
            /// 기본 시간 초과
            if (time > 0) {
                int cnt = time%fees[2]==0 ? time/fees[2] : time/fees[2]+1;
                answer[idx] += (cnt * fees[3]);
            }
            idx++;
        }
        return answer;
    }
    
    int toMinutes(String[] time) {
        return Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
    }
}