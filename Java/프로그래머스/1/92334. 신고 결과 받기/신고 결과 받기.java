import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        /*
        id_list : 이용자의 ID
        report : 각 이용자가 신고한 이용자의 ID
        k : 정지 기준이 되는 신고 횟수
        */
        StringTokenizer st;
        int n = id_list.length;
        
        int[] answer = new int[n];
        Set<String> set = new HashSet<>(Arrays.asList(report));
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (String s : set) {
            st = new StringTokenizer(s);
            String a = st.nextToken();
            String b = st.nextToken();
            int aIdx = -1;
            int bIdx = -1;
            for (int i=0; i<n; i++) {
                if (id_list[i].equals(b)) {
                    bIdx = i;
                    break;
                }
            }
            for (int i=0; i<n; i++) {
                if (id_list[i].equals(a)) {
                    aIdx = i;
                    break;
                }
            }
            List<Integer> list = map.getOrDefault(bIdx, new ArrayList<>());
            list.add(aIdx);
            map.put(bIdx, list);
        }
        for (int bIdx : map.keySet()) {
            List<Integer> list = map.get(bIdx);
            if (list.size() >= k) {
                for (int aIdx : list) {
                    answer[aIdx]++;
                }
            }
        }
        
        return answer;  // 각 유저별로 처리 결과 메일을 받은 횟수
    }
}