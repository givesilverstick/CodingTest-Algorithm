import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1000001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for (int i=4; i<=N; i++) {
			int cnt1 = (i%3==0) ? dp[i/3]+1 : dp[i-1]+1;
			int cnt2 = (i%2==0) ? dp[i/2]+1 : dp[i-1]+1;
			dp[i] = Math.min(cnt1, cnt2);
		}
		System.out.println(dp[N]);
	}
}
