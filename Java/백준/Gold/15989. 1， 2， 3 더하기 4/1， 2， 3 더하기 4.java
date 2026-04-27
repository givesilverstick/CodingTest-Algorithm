import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dp = new int[10001];
		Arrays.fill(dp, 1);	// 1만 있는 경우 : 무조건 1가지씩
		for (int i=2; i<=10000; i++) dp[i] += dp[i-2];	// 2를 더하는 경우 
		for (int i=3; i<=10000; i++) dp[i] += dp[i-3];	// 3을 더하는 경우
		
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			// 조합 구하기 -> dp?
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
	
}
