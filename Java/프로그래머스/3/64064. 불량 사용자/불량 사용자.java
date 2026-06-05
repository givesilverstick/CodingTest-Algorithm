import java.util.*;

class Solution {
    static Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] checkUser = new boolean[user_id.length];
        
        dfs(user_id, banned_id, checkUser, 0);
        int answer = set.size();
        return answer;
    }
    
    public void dfs(String[] user_id, String[] banned_id, boolean[] checkUser, int idx) {
        if (idx == banned_id.length) {
            set.add(Arrays.toString(checkUser));
            return;
        }
        
        for (int i=0; i<user_id.length; i++) {
            String user = user_id[i];
            String banned = banned_id[idx];
            if (!checkUser[i] && user.length()==banned.length()) {
                if (check(user, banned)) {
                    checkUser[i] = true;
                    dfs(user_id, banned_id, checkUser, idx + 1);
                    checkUser[i] = false;
                }
            }
        }
    }
    
    public boolean check(String user, String banned) {
        for (int i=0; i<user.length(); i++) {
            if (banned.charAt(i)!='*'
                && user.charAt(i)!=banned.charAt(i)) return false;
        }
        return true;
    }
}