import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        Map<Character, Integer> countMap = new HashMap<>();
        List<Character> uniqueChars = new ArrayList<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s.toCharArray()) {
            if (countMap.get(c) == 1 && !uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
        }
        
        Collections.sort(uniqueChars);
        
        for (char c : uniqueChars) {
            answer += c;
        }
        return answer;
    }
}