import java.util.*;

class Solution {
    public int solution(int[] citations) {
        /*
        총 논문 수 : n편
            A (h번 이상 인용된 논문 수) : h편 이상
            n - A (나머지) : h편 이하 
        ==> h의 최댓값 : H-Index
        */
        int n = citations.length;
        Arrays.sort(citations);
        for (int h = n; h >= 0; h--) {
            int cnt = 0;
            for (int i=0; i<n; i++) {
                if (citations[i]>=h) {
                    cnt = n-i;
                    break;
                }
            }
            if (cnt >= h) return h;
        }
        
        return 0;
    }
}