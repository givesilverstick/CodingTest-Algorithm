import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int vertex, weight;
		Node next;
		
		Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	// pq용
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
	static int V, E, K, map[][], minDist[];
	static boolean[] visited;
	static Node[] adjList;
	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());	// 정점 수 
		E = Integer.parseInt(st.nextToken());	// 간선 수
		K = Integer.parseInt(br.readLine());	// 시작 정점의 번호
		adjList = new Node[V+1];	// 인접리스트
		minDist = new int[V+1];	// 출발지점에서 자기자신까지의 최소거리
		visited = new boolean[V+1];
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());	// 유향 그래프
			adjList[u] = new Node(v, w, adjList[u]);
		}
		
		// 최단 경로: K번->i번 ==> 다익스트라
		Arrays.fill(minDist, INF);
		minDist[K] = 0;	// 출발점
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(K, minDist[K])); 	// minVertex, min
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			for (Node temp=adjList[cur.vertex]; temp!=null; temp=temp.next) {
				if (!visited[temp.vertex] && minDist[temp.vertex]>cur.weight+temp.weight) {
					minDist[temp.vertex] = cur.weight+temp.weight;
					pq.offer(new Vertex(temp.vertex, minDist[temp.vertex]));
				}
			}
		}
		
		// 출력
		for (int i=1; i<=V; i++) {
			if (minDist[i]!=INF) sb.append(minDist[i]);
			else sb.append("INF");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
