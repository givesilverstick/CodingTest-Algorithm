import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 줄의 개수
        int K = sc.nextInt(); // 총합 K원
        int[] coins = new int[N];
        for (int i=0; i<N; i++) {
            coins[i] = sc.nextInt();
        }
        int count = 0;
        for (int i=N-1; i>=0; i--) {
            if (coins[i] <= K) {
                count += K/coins[i];
                K %= coins[i];
            }
        }
        System.out.println(count); // 출력
    }
}