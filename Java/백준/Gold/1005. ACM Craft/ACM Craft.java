import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 건물 개수  (1번 ~ N번)
			int K = Integer.parseInt(st.nextToken());	// 건설순서 규칙 총 개수 
			// 건물 당 건설에 걸리는 시간 
			int[] D = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			
			List<Integer>[] adj = new ArrayList[N+1];
			int[] indegree = new int[N+1];
			int[] result = new int[N+1];
			for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				adj[X].add(Y);
				indegree[Y]++;
			}
			
			int W = Integer.parseInt(br.readLine());

			Queue<Integer> q = new ArrayDeque<>();
			
			for (int i=1; i<=N; i++) {
				result[i] = D[i];
				if (indegree[i]==0) q.offer(i);
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();

				for (int next : adj[cur]) {
					result[next] = Math.max(result[next], result[cur]+D[next]);
					indegree[next]--;
					if (indegree[next]==0) q.offer(next);
				}
			}
			System.out.println(result[W]);
		}
	}
}
