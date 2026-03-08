import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, minTime;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 수빈 위치 
		K = Integer.parseInt(st.nextToken());	// 동생 위치
		minTime = Integer.MAX_VALUE;	// 수빈->동생 찾는 시간
		bfs();
		System.out.println(minTime);
	}
	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		
		queue.offer(N);
		visited[N] = true;
		int time = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				int cur = queue.poll();
				if (cur==K) {
					minTime = Math.min(minTime, time);
					return;
				}
				if (cur*2 <= 100000 && !visited[cur*2]) {
					queue.offer(cur*2);
					visited[cur*2] = true;
				}
				if (cur<100000 && !visited[cur+1]) {
					queue.offer(cur+1);
					visited[cur+1] = true;
				}
				if (cur>0 && !visited[cur-1]) {
					queue.offer(cur-1);
					visited[cur-1] = true;
				}
			}
			time++;
		}
		
	}
}
