import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//	 물품의 수
		int K = Integer.parseInt(st.nextToken());	// 준서가 버틸 수 있는 무게
		int[] dp = new int[K+1];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());	// 물건의 무게
			int V = Integer.parseInt(st.nextToken()); 	// 물건의 가치
			// 혼자 다시 해보기
			for (int j=K; j>=W; j--) {
				dp[j] = Math.max(dp[j], dp[j-W]+V);
			}
		}
		
		System.out.println(dp[K]);
	}

}
