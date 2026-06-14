import java.util.*;

class Solution {
    static int[] answer = new int[2];  // 임티플 가입 수, 이모티콘 매출액(행사 목적 최대한 달성)
    public int[] solution(int[][] users, int[] emoticons) {
        /*
        <goal>
        1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        2. 이모티콘 판매액을 최대한 늘리는 것.
        
        할인율 10%, 20%, 30%, 40%
        */
        
        dfs(users, emoticons, 0, new int[emoticons.length]);
        
        return answer;
    }
    
    void dfs(int[][] users, int[] emoticons, int idx, int[] sales) {
        if (idx==emoticons.length) {
            int userCnt = 0;
            int totalPrice = 0;
            for (int[] user : users) {
                int minSale = user[0];
                int price = user[1];
                
                int sum = 0;
                for (int i=0; i<emoticons.length; i++) {
                    if (sales[i]>=minSale) {
                        sum += emoticons[i]*(100-sales[i])/100;
                    }
                }
                if (sum >= price) userCnt++;
                else totalPrice += sum;
            }
            
            if (userCnt > answer[0]) {
                answer[0] = userCnt;
                answer[1] = totalPrice;
            } else if (userCnt == answer[0]) {
                answer[1] = Math.max(answer[1], totalPrice);
            }
            return;
        }
        for (int sale=40; sale>=10; sale-=10) {
            sales[idx] = sale;
            dfs(users, emoticons, idx+1, sales);   // 할인 적용
        }
    }
}