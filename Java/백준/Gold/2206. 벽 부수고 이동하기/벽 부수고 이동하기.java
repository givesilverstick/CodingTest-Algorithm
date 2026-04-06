import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	final static int INF = Integer.MAX_VALUE;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static int N, M, map[][], result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		result = INF;
		bfs();
		
		System.out.println(result==INF?-1:result);
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[2][N][M];
		q.offer(new int[] {0,0, 1, 0});
		visited[0][0][0] = true;
		visited[1][0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0]==N-1 && cur[1]==M-1) {
				result = Math.min(result, cur[2]);
			}
			for (int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if (nr<0 || nr>=N || nc<0 || nc>=M || visited[cur[3]][nr][nc]) continue;
				if (map[nr][nc]==0) {
					visited[cur[3]][nr][nc] = true;
					q.offer(new int[] {nr,nc,cur[2]+1, cur[3]});
					
				} else if (map[nr][nc]==1 && cur[3]<1) {
					visited[cur[3]][nr][nc] = true;
					q.offer(new int[] {nr,nc, cur[2]+1, cur[3]+1});
				}
			}
		}
	}
}
