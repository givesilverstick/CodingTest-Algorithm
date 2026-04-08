import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 메모리 :  kb,
 * 실행시간 :  ms
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 집의 수
		int[][] dp = new int[N][3];	// n번째 집의 R,G,B 각각 선택할 때 최소비용 
		int[][] map = new int[N][3];	
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0; i<3; i++) {
			dp[0][i] = map[0][i];
		}
		for (int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
		}
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
}
