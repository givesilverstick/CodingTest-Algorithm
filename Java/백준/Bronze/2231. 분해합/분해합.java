import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = 0;
        
        for (int i=1; i<N; i++) {
            int sum = i;
            for (int j=i; j>0; j/=10) {
                sum += j%10;
            }
            if (sum == N) {
                M = i;
                break;
            }
        }
        System.out.println(M);
    }
}