import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // n: 총 학생 수, lost: 도난, reserve: 여벌
        
        // set 사용
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);
        
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r); // 여벌 있는데 도난 당한 경우
                reserveSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }
        for (int r : reserveSet) {
            if (lostSet.contains(r-1)) {
                lostSet.remove(r-1);
            } else if (lostSet.contains(r+1)) {
                lostSet.remove(r+1);
            }
        }
        int answer = n-lostSet.size();
        // 틀린
//         int answer = n-lost.length;
//         boolean[] borrow = new boolean[lost.length];
        
        
//         for (int i=0; i<reserve.length; i++) {
//             for (int j=0; j<lost.length; j++) {
//                 // 여벌 있는 학생이 도난 당한 경우를 생각 못 함
//                 if (reserve[i] == lost[j] && !borrow[j]) {
//                     answer++;
//                     borrow[j] = true;
//                     break;
//                 }
//                 if (reserve[i]-1 > 0 && reserve[i]-1 == lost[j] && !borrow[j]) {
//                     answer++;
//                     borrow[j] = true;
//                     break;
//                 }
//                 if (reserve[i]+1 <= n && reserve[i]+1 == lost[j] && !borrow[j]) {
//                     answer++;
//                     borrow[j] = true;
//                     break;
//                 }
//             }
//         }
        return answer;
    }
}