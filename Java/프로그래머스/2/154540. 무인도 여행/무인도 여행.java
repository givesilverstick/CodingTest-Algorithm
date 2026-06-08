import java.util.*;

class Solution {
    
    static int[] dr = {-1,1,0,0}, dc={0,0,-1,1};
    static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answerList = new ArrayList<>();
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                if (!visited[i][j] && maps[i].charAt(j)!='X') {
                    int cnt = bfs(i,j, maps);
                    answerList.add(cnt);
                }
            }
        }
        
        if (answerList.size() == 0) answerList.add(-1);
        int[] answer = new int[answerList.size()];
        
        for (int i=0; i<answerList.size(); i++) answer[i] = answerList.get(i);
        Arrays.sort(answer);
        
        return answer;
    }
    
    int bfs(int r, int c, String[] maps) {
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r,c});
        visited[r][c] = true;
        int sum = maps[r].charAt(c) - '0';
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d=0; d<4; d++) {
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];
                if (nr<0 || nr>=maps.length || nc<0 || nc>=maps[nr].length()
                    || visited[nr][nc]) continue;
                if (maps[nr].charAt(nc)!='X') {
                    q.offer(new int[] {nr,nc});
                    visited[nr][nc] = true;
                    sum += maps[nr].charAt(nc) - '0';
                }
            }
        }
        return sum;
    }
}