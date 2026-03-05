import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static int R, C, minTime;
	static char map[][];
	static String result;
	static Queue<int[]> fireQ, manQ;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	// 미로의 행
		C = Integer.parseInt(st.nextToken());	// 미로의 열
		result = "";
		map = new char[R][C];
		minTime = 0;
		fireQ = new ArrayDeque<>();	// 불 좌표
		manQ = new ArrayDeque<>();	// 탈출하려는 사람 좌표
		visited = new boolean[R][C];
		for (int i=0; i<R; i++) {
			String line = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j]=='J') {
					manQ.offer(new int[] {i,j});
					visited[i][j] = true;
					map[i][j] = '.';
				} else if (map[i][j]=='F') {
					fireQ.offer(new int[] {i,j});
				}
			}
		}
		
		// solve
		bfs();
		if (result.length()==0) sb.append(minTime);
		else sb.append(result);
		sb.append("\n");
		System.out.println(sb);
	}
	
	public static void bfs() {
		
		// 지훈이가 탈출하기 전까지
		while (!manQ.isEmpty()) {
			minTime++;
			// 불 옮겨붙음
			int fsize = fireQ.size();
			for (int i=0; i<fsize; i++) {
				int cur[] = fireQ.poll();
				for (int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if (nr>=0 && nr<R && nc>=0 && nc<C) {
						if (map[nr][nc]=='.') {
							map[nr][nc] = 'F';
							fireQ.offer(new int[] {nr,nc});
						} 
					}
				}
			}
			
			// 지훈이 이동
			int msize = manQ.size();
			for (int i=0; i<msize; i++) {
				int cur[] = manQ.poll();
				for (int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					// 탈출
					if (nr<0 || nr>=R || nc<0 || nc>=C) {
						return;
					}
					// 이동
					if (!visited[nr][nc] && map[nr][nc]=='.') {
						manQ.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
				}
			}			
		}
		result = "IMPOSSIBLE";
	}
}
