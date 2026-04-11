import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[100001];
		Deque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {N,0});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int now = cur[0];
			int time = cur[1];
			
			if (now<0 || now>100000 || visited[now]) continue;
			visited[now] = true;
			
			if (now==K) {
				System.out.println(time);
				break;
			}
			if (now*2<=100000 && !visited[now*2]) q.offerFirst(new int[] {now*2, time});
			if (now+1<=100000 && !visited[now+1]) q.offerLast(new int[] {now+1,time+1});
			if (now-1>=0 && !visited[now-1]) q.offerLast(new int[] {now-1, time+1});
		}
	}
}
