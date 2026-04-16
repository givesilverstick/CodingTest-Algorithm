import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, maxCnt;
	static char map[][];
	static boolean visited[][], checked[];
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	public static class CoorD {
		int x, y;
		CoorD(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		

		R = Integer.parseInt(st.nextToken());	// 세로
		C = Integer.parseInt(st.nextToken());	// 가로
		map = new char[R][C];	// 보드
		visited = new boolean[R][C];
		checked = new boolean['Z'-'A'+1];
		maxCnt = 1;
		for (int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		checked[map[0][0]-'A'] = true;
		dfs(0,0,0);
		System.out.println(maxCnt);
	}
	
	public static void dfs(int r, int c, int cnt) {
		
		visited[r][c] = true;
		cnt++;
		maxCnt = Math.max(maxCnt, cnt);
		
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if (nr>=0&&nr<R && nc>=0&&nc<C && !visited[nr][nc] && !checked[map[nr][nc]-'A']) {
				checked[map[nr][nc]-'A'] = true;
				dfs(nr,nc, cnt);
				checked[map[nr][nc]-'A'] = false;
			}
		}
		visited[r][c] = false;
	}
}
