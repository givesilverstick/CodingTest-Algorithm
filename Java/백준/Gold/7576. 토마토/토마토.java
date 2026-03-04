import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static int M, N, box[][], minDay;
	static Queue<int[]> queue;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 상자의 가로 칸의 수 (col)
		M = Integer.parseInt(st.nextToken());	// 상자의 세로 칸의 수 (row)
		box = new int[M][N];
		minDay = 0;
		queue = new ArrayDeque<>();
		visited = new boolean[M][N];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j]==1) {
					queue.offer(new int[] {i,j});
					visited[i][j] = true;
				} else if (box[i][j]==-1) visited[i][j] = true;
			}
		}
		/*
		 * 보관 후 하루가 지나면 -> 익은 토마토들의 인접 토마토 익음
		 * 모든 토마토가 익는 날짜 min?
		 */
		
		// solve
		bfs();
		boolean canAll = true;
		a: for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					canAll = false;
					break a;
				}
			}
		}
		
		if (canAll) System.out.println(minDay);
		else System.out.println(-1);
	}
	
	public static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean isSpread = false;
			for (int i=0; i<size; i++) {
				int cur[] = queue.poll();
				for (int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if (nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc]) {
						if (box[nr][nc]==0) {
							box[nr][nc] = 1;
							queue.offer(new int[] {nr,nc});
							visited[nr][nc] = true;
							isSpread = true;
						} 
					}
				}
			}
			if (isSpread) minDay++;
		}
	}
}
