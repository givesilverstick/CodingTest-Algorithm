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
        
        // 첫 시작 단어
        queue.offer(new WordNode(begin, 0));
        visited.add(begin);
        
        while (!queue.isEmpty()) {
            WordNode node = queue.poll();
            // 타겟과 같을 때
            if (node.word.equals(target)) return node.step;
            
            // 타겟과 다를 때
            
            for (String w : words) {
                if (isOneDiff(w, node.word) && !visited.contains(w)) {
                    System.out.println(w);
                    queue.offer(new WordNode(w, node.step+1));
                    visited.add(w);
                }
            }
            
        }
        return answer;
    }
    private boolean isOneDiff(String a, String b) {
        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}