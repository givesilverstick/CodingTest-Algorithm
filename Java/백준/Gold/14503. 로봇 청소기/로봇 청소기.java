import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], count;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());	// 바라보는 방향 : 0(북), 1(동), 2(남), 3(서)
		map = new int[N][M];
		count = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 1: 벽, 0: 청소X
			}
		}
		// solve
		solve(r,c,d);
		
		System.out.println(count);
	}
	
	public static void solve(int r, int c, int d) {
		// 1. 현재 칸이 청소되지 않은 경우, 청소
		if (map[r][c]==0) {
			map[r][c] = 2;
			count++;
		}
		
		boolean needClean = false;
		for (int d1=0; d1<4; d1++) {
			int nr = r+dr[d1];
			int nc = c+dc[d1];
			if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0) {
				needClean = true;
				break;
			}
		}
		// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우 - 후진
		if (!needClean) {
			switch(d) {
				case 0:
					if (r<N-1) {
						if (map[r+1][c]==1) return;
						r++;
					}
					break;
				case 1:
					if (c>0) {
						if (map[r][c-1]==1) return;
						c--;
					}
					break;
				case 2:
					if (r>0) {
						if (map[r-1][c]==1) return;
						r--;
					}
					break;
				case 3:
					if (c<M-1) {
						if (map[r][c+1]==1) return;
						c++;
					}
					break;
				}
		}
		// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우 - 반시계 회전 & 전진
		else {
			// 반시계 회전
			d--;
			if (d<0) d+=4;
			
			switch(d) {
				case 0:
					if (r>0 && map[r-1][c]==0) r--;
					break;
				case 1:
					if (c<M-1 && map[r][c+1]==0) c++;
					break;
				case 2:
					if (r<N-1 && map[r+1][c]==0) r++;
					break;
				case 3:
					if (c>0 && map[r][c-1]==0) c--;
					break;
				}
		}

		solve(r, c, d);	
	}
}
