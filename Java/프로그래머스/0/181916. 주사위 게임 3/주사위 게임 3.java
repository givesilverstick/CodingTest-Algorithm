import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        d = arr[3];
        
        if (a == b && b == c && c == d) {
            answer = 1111 * a;
        } else if (b == c && c == d) {
            answer = (int) Math.pow(10*b+a, 2);
        } else if (a == b && b == c) {
            answer = (int) Math.pow(10*a+d, 2);
        } else if (a == b && c == d) {
            answer = (a+c) * (Math.abs(a-c));
        } else if (a == b) {
            answer = c * d;
        } else if (b == c) {
            answer = a * d;
        } else if (c == d) {
            answer = a * b;
        } else {
            answer = a;
        }
        return answer;
    }
}