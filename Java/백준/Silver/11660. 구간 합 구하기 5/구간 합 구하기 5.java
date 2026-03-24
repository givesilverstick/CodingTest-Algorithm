import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int D[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 표 크기 N*N
		int M = Integer.parseInt(st.nextToken());	// 합을 구해야 하는 횟수
		D = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				int val = Integer.parseInt(st.nextToken());
				D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + val;
			}
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
