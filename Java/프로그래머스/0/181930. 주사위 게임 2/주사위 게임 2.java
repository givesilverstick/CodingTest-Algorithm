class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if ( a==b && b==c) {
            answer = (a+b+c)*(cal(a,2) + cal(b,2) + cal(c,2))*(cal(a,3) + cal(b,3) + cal(c,3));
        } else if (a==b || a==c || b==c) {
            answer = (a+b+c)*(cal(a,2) + cal(b,2) + cal(c,2));
        } else {
            answer = a+b+c;
        }
        return answer;
    }
    
    int cal(int a, int b) {
        int sum = 1;
        for (int i=0; i<b; i++) {
            sum *= a;
        }
        return sum;
    }
}