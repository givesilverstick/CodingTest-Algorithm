import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 수의 개수
        int M = sc.nextInt(); // 합을 구해야 하는 횟수
        
        int[] nums = new int[N];
        // 시간 복잡도 해결 X -> 누적합 이용
        int[] prefix = new int[N+1];
        
        for (int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
            prefix[i+1] = prefix[i] + nums[i];
            // prefix[1] = nums[0];
            // prefix[2] = prefix[1]+nums[1] = nums[0]+nums[1];
            // prefix[3]
        }
        
        for (int x=0; x<M; x++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int sum = prefix[j] - prefix[i-1];
            System.out.println(sum);
        }
    }
}