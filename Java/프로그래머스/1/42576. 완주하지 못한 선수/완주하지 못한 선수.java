import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 중복 고려X, HashMap 사용 못해서 틀림
        Map<String, Integer> map = new HashMap<>();
        
        // 참가자 이름 맵에 카운트
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 완주한 사람 이름 카운트 줄이기 -> 미완주한 사람을 찾아야 함.
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        // 값이 1인 사람이 완주 못 한 사람
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                answer = key;
            }
        }
        return answer;
    }
}