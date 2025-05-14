import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] scores = new int[N];
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<N; i++) {
            scores[i] = sc.nextInt();
            if (scores[i] > max) max = scores[i];
        }
        
        double sum = 0;
        for (int i=0; i<N; i++) {
            sum += (double) scores[i]/max*100;
        }
        
        System.out.println(sum / N);
    }
}