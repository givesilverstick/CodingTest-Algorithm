import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	static char[][] board;
	static int N, M, r1, c1, r2, c2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		r1 = c1 = r2 = c2 = -1;
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				board[i][j] = line.charAt(j);
				if (board[i][j]=='o') {
					if (r1==-1) {r1 = i; c1 = j;}
					else {r2 = i; c2 = j;}
				}
			}
		}
		
		int cnt = bfs();
		System.out.println(cnt);
	}
	
	static int  bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r1, c1, r2, c2, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR1 = cur[0], curC1 = cur[1], curR2 = cur[2], curC2 = cur[3], count = cur[4];
			
			if (count >= 10) continue;
			
			for (int d=0; d<4; d++) {
				int nr1 = curR1+dr[d];
				int nc1 = curC1+dc[d];
				int nr2 = curR2+dr[d];
				int nc2 = curC2+dc[d];
				
				boolean dropped1 = (nr1<0 || nr1>=N || nc1<0 || nc1>=M);
				boolean dropped2 = (nr2<0 || nr2>=N || nc2<0 || nc2>=M);
				
				if (dropped1 ^ dropped2) {	// XOR
					return count+1;
				}
				if (dropped1 && dropped2) continue;
				
				if (!dropped1 && board[nr1][nc1]=='#') {
					nr1 = curR1;
					nc1 = curC1;
				}
				if (!dropped2 && board[nr2][nc2]=='#') {
					nr2 = curR2;
					nc2 = curC2;
				}
				q.offer(new int[] {nr1, nc1, nr2, nc2, count+1});
			}
		}
		return -1;
	}
}
