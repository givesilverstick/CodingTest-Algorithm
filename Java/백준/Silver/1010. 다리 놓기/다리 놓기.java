import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[30][30];
			for (int j=1; j<30; j++) {
				dp[1][j] = j;
			}
			
			for (int i=2; i<=N; i++) {
				for (int j=i; j<=M; j++) {
					if (i==j) dp[i][j] = 1;
					else {
						dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
					}
				}
			}
			sb.append(dp[N][M]).append("\n");
		}
		System.out.println(sb);
	}
}
