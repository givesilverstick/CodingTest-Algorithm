import java.util.*;

class Solution {
    class Word {
        String word;
        int step;
        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) return 0;
        
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word cur = queue.poll();
            String word = cur.word;
            int step = cur.step;
            if (word.equals(target)) return step;
            
            Iterator<String> it = wordSet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (canChange(word, next)) {
                    queue.add(new Word(next, step+1));
                    it.remove();
                }
            }
        }
        
        return answer;
    }
    
    boolean canChange(String a, String b) {
        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}