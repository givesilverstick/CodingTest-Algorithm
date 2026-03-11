import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Node {
		int vertex, weight;
		Node next;
		
		Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
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
	
	static int V, E, parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	// 정점 개수
			E = Integer.parseInt(st.nextToken());	// 간선 개수
			Node[] adjList = new Node[V];
			boolean[] visited = new boolean[V];
			int[] minEdge = new int[V];
			
			for (int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());	// 가중치
				adjList[A-1] = new Node(B-1, C, adjList[A-1]);
				adjList[B-1] = new Node(A-1, C, adjList[B-1]);
			}
			
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[0] = 0;
			
			long result = 0;
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, 0));	// minVertex, min
			
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll();
				
				if (visited[cur.vertex]) continue;
				
				visited[cur.vertex] = true;
				result += cur.weight;
				
				for (Node temp=adjList[cur.vertex]; temp!=null; temp=temp.next) {
					if (!visited[temp.vertex] && minEdge[temp.vertex]>temp.weight) {
						minEdge[temp.vertex] = temp.weight;
						pq.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
					}
				}
					
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
