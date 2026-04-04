import java.io.*;
import java.util.*;

public class Main {

	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i=0; i<R; i++) {
			String line = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int N = Integer.parseInt(br.readLine());	// 막대 던진 횟수
		
		boolean toRight = true;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int height = Integer.parseInt(st.nextToken());
			//L -> R 
			boolean isBreak = false;
			if (toRight) {
				for (int j=0; j<C; j++) {
					if (map[R-height][j]=='x') {
						map[R-height][j] = '.';
						isBreak = true;
						break;
					}
				}
			}
			// R -> L
			else {
				for (int j=C-1; j>=0; j--) {
					if (map[R-height][j]=='x') {
						map[R-height][j] = '.';
						isBreak = true;
						break;
					}
				}
			}
			// 클러스터 분리됐을 때 중력 처리
			visited = new boolean[R][C];
			if (isBreak) {
				// 바닥 방문 처리
				for (int c=0; c<C; c++) {
					if (map[R-1][c]=='x' && !visited[R-1][c]) {
						bfs(R-1, c);
					}
				}
				// 공중에 뜬 클러스터 처리
				List<int[]> cluster = new ArrayList<>();
				for (int r=R-2; r>=0; r--) {
					for (int c=0; c<C; c++) {
						if (map[r][c]=='x' && !visited[r][c]) {
							cluster.add(new int[] {r,c});
							map[r][c] = '.';
						}
					}
				}
				
				int move = 0;
				outer : while (!cluster.isEmpty()) {
					int next = move+1;
					for (int[] cur : cluster) {
						int nr = cur[0]+next;
						int nc = cur[1];
						
						if (nr >= R || map[nr][nc]=='x') break outer;
					}
					move = next;
				}
				
				for (int[] cur : cluster) {
					map[cur[0]+move][cur[1]] = 'x';
				}
			}

			toRight = !toRight;	// 방향 변경 
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	static int bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {r,c});
		visited[r][c] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if (nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]) continue;
				if (map[nr][nc]=='x') {
					q.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
