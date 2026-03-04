import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static int W, H, minTime;
	static char map[][];
	static String result;
	static Queue<int[]> fireQ, manQ;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());	// 지도의 너비(col)
			H = Integer.parseInt(st.nextToken());	// 지도의 높이(row)
			result = "";
			map = new char[H][W];
			minTime = 0;
			fireQ = new ArrayDeque<>();	// 불 좌표
			manQ = new ArrayDeque<>();	// 탈출하려는 사람 좌표
			visited = new boolean[H][W];
			for (int i=0; i<H; i++) {
				String line = br.readLine();
				for (int j=0; j<W; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j]=='@') {
						manQ.offer(new int[] {i,j});
						visited[i][j] = true;
						map[i][j] = '.';
					} else if (map[i][j]=='*') {
						fireQ.offer(new int[] {i,j});
					}
				}
			}
			
			// solve
			bfs();
			if (result.length()==0) sb.append(minTime);
			else sb.append(result);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		
		// 상근이가 탈출하기 전까지
		while (!manQ.isEmpty()) {
			minTime++;
			// 불 옮겨붙음
			int fsize = fireQ.size();
			for (int i=0; i<fsize; i++) {
				int cur[] = fireQ.poll();
				for (int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if (nr>=0 && nr<H && nc>=0 && nc<W) {
						if (map[nr][nc]=='.') {
							map[nr][nc] = '*';
							fireQ.offer(new int[] {nr,nc});
						} 
					}
				}
			}
			
			// 상근이 이동
			int msize = manQ.size();
			for (int i=0; i<msize; i++) {
				int cur[] = manQ.poll();
				for (int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					// 탈출
					if (nr<0 || nr>=H || nc<0 || nc>=W) {
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
