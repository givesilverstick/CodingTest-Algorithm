import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stkList = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            if (stkList.size() == 0) {
                stkList.add(arr[i]);
            } else {
                if (stkList.get(stkList.size()-1) < arr[i]) {
                    stkList.add(arr[i]);
                } else {
                    stkList.remove(stkList.size()-1);
                    i -= 1;
                }
            }
        }
        
        int[] stk = stkList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return stk;
    }
}