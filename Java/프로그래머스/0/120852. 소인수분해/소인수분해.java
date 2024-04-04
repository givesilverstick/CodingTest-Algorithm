import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                if (!primes.contains(i)) {
                    primes.add(i);
                }
                n /= i;
            }
        }
        
        int[] answer = new int[primes.size()];
        for (int i = 0; i < primes.size(); i++) {
            answer[i] = primes.get(i);
        }
        return answer;
    }
}