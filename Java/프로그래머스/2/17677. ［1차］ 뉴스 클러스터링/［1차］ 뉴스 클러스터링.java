import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 다중집합 원소 만들기 : 두 글자씩 끊기
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        List<Integer> cnt1 = new ArrayList();
        List<Integer> cnt2 = new ArrayList();
        for (int i=0; i<str1.length()-1; i++) {
            String word = "";
            if (isPossible(str1.charAt(i)) && isPossible(str1.charAt(i+1))) {
                word = str1.substring(i,i+2).toUpperCase();
                // 없는 경우
                int idx = list1.indexOf(word);
                if (idx == -1) {
                    list1.add(word);
                    cnt1.add(1);
                }
                // 이미 있는 경우
                else {
                    cnt1.set(idx, cnt1.get(idx)+1);
                }
            }
        }
        
        for (int i=0; i<str2.length()-1; i++) {
            String word = "";
            if (isPossible(str2.charAt(i)) && isPossible(str2.charAt(i+1))) {
                word = str2.substring(i,i+2).toUpperCase();
                // 없는 경우
                int idx = list2.indexOf(word);
                if (idx == -1) {
                    list2.add(word);
                    cnt2.add(1);
                }
                // 이미 있는 경우
                else {
                    cnt2.set(idx, cnt2.get(idx)+1);
                }
            }
        }
        
        // 교집합, 합집합 만들기
        List<String> union = new ArrayList<>();
        int result1 = 0; // 교집합 개수
        int result2 = 0; // 합집합 개수
        for(int i=0; i<list1.size(); i++) {
            String word = list1.get(i);
            
            int idx1 = list1.indexOf(word);
            int idx2 = list2.indexOf(word);
            // 같은 글자 있을 때
            if (list2.indexOf(word) != -1) {
                result1 += Math.min(cnt1.get(idx1), cnt2.get(idx2));
                result2 += Math.max(cnt1.get(idx1), cnt2.get(idx2));
            }
            // 같은 글자 없을 때
            else {
                result2 += cnt1.get(idx1);
            }
            union.add(word);
        }
        for(int i=0; i<list2.size(); i++) {
            String word = list2.get(i);
            int idx = list2.indexOf(word);
            if (union.indexOf(word) == -1) {
                result2 += cnt2.get(idx);
            }
        }
        
        // 자카드 유사도 계산
        if (list1.size()==0 && list2.size()==0) answer = 65536;
        else answer = 65536*result1/result2;
        return answer;
    }
    
    boolean isPossible(char c) {
        if (c == ' ') return false;
        
        if ((c>='a' && c<='z') || 
            (c>='A' && c<='Z')) return true;
        
        return false;
    }
}