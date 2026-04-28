import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        Set<String> key = map.keySet();
        if (key.size()==1) return clothes.length;
        for (String s : map.keySet()) {
            answer *= map.get(s)+1;
        }
        return answer-1;
    }
}