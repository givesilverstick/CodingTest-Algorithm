import java.util.*;

class Solution {
    
    static int answer;
    static List<String> wordList;
    static boolean[] checked;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        wordList = new ArrayList<>();
        checked = new boolean[words.length];
        for (String word : words) wordList.add(word);
        
        if (!wordList.contains(target)) return 0;
        
        dfs(0, begin, target);
        
        return answer;
    }
    
    void dfs(int cnt, String cur, String target) {
        if (cur.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for (int i=0; i<wordList.size(); i++) {
            if (!checked[i] && canChange(cur, wordList.get(i))) {
                checked[i] = true;
                dfs(cnt+1, wordList.get(i), target);
                checked[i] = false;
            }
        }
        
    }
    
    boolean canChange(String word1, String word2) {
        int diff = 0;
        for (int i=0; i<word1.length(); i++) {
            if (diff > 1) return false;
            if (word1.charAt(i)!=word2.charAt(i)) diff++;
        }
        return diff==1 ? true : false;
    }
}