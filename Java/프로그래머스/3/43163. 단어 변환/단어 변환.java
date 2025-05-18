import java.util.*;
class Solution {
    class WordNode {
        String word;
        int step;
        WordNode(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<WordNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(new WordNode(begin, 0)); // .offer() -> 안전
        visited.add(begin);
        
        while (!queue.isEmpty()) {
            WordNode node = queue.poll();
            
            if (node.word.equals(target)) {
                return node.step;
            }
            
            for (String w : words) {
                if (!visited.contains(w) && isOneLetterDifferent(node.word, w)) {
                    queue.add(new WordNode(w, node.step+1));
                    visited.add(w);
                }
            }
        }
        return answer;
    }
    private boolean isOneLetterDifferent(String a, String b) {
        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}