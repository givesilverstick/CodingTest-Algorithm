import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][];
	static int[] dr={-1,1,0,0}, dc={0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		//solve
		bfs(0,0);
		
		System.out.println(map[N-1][M-1]);
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;
		queue.offer(new int[] {r,c});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			r = cur[0];
			c = cur[1];
			if (r==N && c==M) return;
			for (int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if (nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]>0) {
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
					map[nr][nc] = map[r][c]+1;
				}
			}
		}
		
	}
}
