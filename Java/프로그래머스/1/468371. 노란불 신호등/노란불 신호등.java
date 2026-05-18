class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        /*
        초 -> 노 -> 빨
        - 신호등 개수 : n개
        - 정전 발생 : 모든 신호등이 노란색.
        */
        
        int maxLimit = 1;
        for (int[] signal : signals) {
            int period = signal[0]+signal[1]+signal[2];
            maxLimit = lcm(maxLimit, period);
        }
        for (int t=0; t<maxLimit; t++) {
            boolean allYellow = true;
            
            for (int i=0; i<signals.length; i++) {
                int green = signals[i][0];
                int yellow = signals[i][1];
                int red = signals[i][2];
                int period = green + yellow + red;
                int remain = t % period;
                // yellow 범위가 아닐 때 종료
                if (remain <= green || remain > (green+yellow)) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return t;
            }
        }
        return answer;
    }
    
    // 최대공약수
    int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }
    
    // 최소공배수
    int lcm(int a, int b) {
        return (a * b) / gcd(a,b);
    }
}