import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, A[], operCnt[], max, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());	// 수의 개수
		st = new StringTokenizer(br.readLine());
		A = new int[N];	// 수
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		operCnt = new int[4];	// +-*/ 개수
		for (int i=0; i<4; i++) {
			operCnt[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		// solve
		dfs(0, A[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int cnt, int sum) {
		if (cnt==N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if (operCnt[0]>0) {
			operCnt[0]--;
			dfs(cnt+1, sum+A[cnt+1]);
			operCnt[0]++;
		}
		if (operCnt[1]>0) {
			operCnt[1]--;
			dfs(cnt+1, sum-A[cnt+1]);
			operCnt[1]++;
		}
		if (operCnt[2]>0) {
			operCnt[2]--;
			dfs(cnt+1, sum*A[cnt+1]);
			operCnt[2]++;
		}
		if (operCnt[3]>0) {
			operCnt[3]--;
			dfs(cnt+1, sum/A[cnt+1]);
			operCnt[3]++;
		}
	}
}
