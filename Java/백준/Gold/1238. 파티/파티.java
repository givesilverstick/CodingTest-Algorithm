import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int next, weight;
		Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		int vertex, weight;
		Vertex(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
//		Node[] adjList = new Node[];
		List<Node>[] adjList = new ArrayList[N+1];
		List<Node>[] adjListReverse = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			adjListReverse[i] = new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			adjList[start].add(new Node(end, time));
			adjListReverse[end].add(new Node(start, time));
		}
		
		int[] dist = new int[N+1];
		int[] dist2 = new int[N+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		Arrays.fill(dist, INF);
		Arrays.fill(dist2, INF);
		dist[X] = 0;
		dist2[X] = 0;
		pq.offer(new Vertex(X, dist[X]));
		
		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			for (Node temp : adjList[cur.vertex]) {
				if (dist[temp.next] > dist[cur.vertex]+temp.weight) {
					dist[temp.next] = dist[cur.vertex]+temp.weight;
					pq.offer(new Vertex(temp.next, dist[temp.next]));
				}
			}
		}

		pq.offer(new Vertex(X, dist[X]));
		
		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			for (Node temp : adjListReverse[cur.vertex]) {
				if (dist2[temp.next] > dist2[cur.vertex]+temp.weight) {
					dist2[temp.next] = dist2[cur.vertex]+temp.weight;
					pq.offer(new Vertex(temp.next, dist2[temp.next]));
				}
			}
		}
		
		int result = 0;
		for (int i=1; i<=N; i++) {
			result = Math.max(result, dist[i]+dist2[i]);
		}
		System.out.println(result);
	}
	
}
