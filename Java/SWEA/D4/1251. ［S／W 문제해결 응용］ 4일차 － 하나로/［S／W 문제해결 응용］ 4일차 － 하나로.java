import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	// 인접 리스트
	static class Node {
		int no;
		long weight;
		Node next;
		
		Node(int no, long weight, Node next) {
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
	}
	
	// 우선순위 큐
	static class Vertex implements Comparable<Vertex> {
		int no;
		long weight;
		
		Vertex(int no, long weight) {
			this.no = no;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static int[][] land;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 섬의 개수
			land = new int[N][2];
			// x좌표
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				land[i][0] = Integer.parseInt(st.nextToken());
			}
			// y좌표
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				land[i][1] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());	// 환경 부담 세율
			
			Node[] adjList = new Node[N];
			boolean[] visited = new boolean[N];
			long[] minEdge = new long[N];
			
			for (int i=0; i<N; i++) {
				for (int j=i+1; j<N; j++) {
					long weight = calWeight(i, j);
					adjList[i] = new Node(j, weight, adjList[i]);
					adjList[j] = new Node(i, weight, adjList[j]);
				}
			}
			
			Arrays.fill(minEdge, Long.MAX_VALUE);
			minEdge[0] = 0;
			
			int count = 0;
			long result = 0;
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, minEdge[0]));
			
			while(!pq.isEmpty()) {
				
				Vertex cur = pq.poll();
				if (visited[cur.no]) continue;
				visited[cur.no] = true;
				result += cur.weight;
				
				if (++count == N) break;
				
				for (Node temp=adjList[cur.no]; temp!=null; temp=temp.next) {
					if (!visited[temp.no] && minEdge[temp.no] > temp.weight) {
						minEdge[temp.no] = temp.weight;
						pq.offer(new Vertex(temp.no, minEdge[temp.no]));
					}
				}
			}
			result = (long) Math.round(E*result);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");

		}
		System.out.println(sb);
	}
	
	static long calWeight(int start, int end) {
		long width = Math.abs((long)land[start][0]-land[end][0]);
		long height = Math.abs((long)land[start][1]-land[end][1]);
		return width*width + height*height;
	}
}
