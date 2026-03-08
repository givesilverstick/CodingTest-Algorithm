import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[] visited;
	static List<Integer>[] list;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 정점 수
		int M = Integer.parseInt(st.nextToken());	// 간선 수
		int V = Integer.parseInt(st.nextToken());	// 시작 정점 번호
		list = new ArrayList[N+1];
		for (int i=1; i<=N; i++) list[i] = new ArrayList<>();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		// 정렬
		for (int i=1; i<=N; i++) list[i].sort((a,b)->a-b);
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		bfs(V);
		sb.append("\n");
		System.out.println(sb);
	}
	
	public static void dfs(int num) {
		if (visited[num]) return;
		visited[num] = true;
		sb.append(num).append(" ");
		
		int size = list[num].size();
		if (size==0) return;
		for (int i=0; i<size; i++) {
			int next = list[num].get(i);
			if (visited[next]) continue;
			dfs(next);
		}
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			int size = list[cur].size();
			if (size==0) return;
			for (int i=0; i<size; i++) {
				int next = list[cur].get(i);
				if (visited[next]) continue;
				queue.offer(next);
				visited[next] = true;
			}
		}
		
	}
}
