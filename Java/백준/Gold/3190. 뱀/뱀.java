import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr= {-1,0,1,0}, dc= {0,1,0,-1}; //상우하좌
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());	// 보드 크기 N*N
		int K = Integer.parseInt(br.readLine());	// 사과의 개수
		boolean[][] board = new boolean[N+1][N+1];
		// 사과의 위치
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = true;
		}
		
		int L = Integer.parseInt(br.readLine());	// 뱀의 방향 변환 횟수
		// 뱀의 방향 변환 정보
		Map<Integer, Character> dirInfo = new HashMap<>();
		for (int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			dirInfo.put(X, C);
		}
		
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		int dir = 1;	// 뱀의 초기 방향
		q.offer(new int[] {1,1});
		visited[1][1] = true;
		int time;
		
		for (time=1; time<=10000; time++) {
			int[] cur = q.peekFirst();
			int r = cur[0];
			int c = cur[1];
			
			// 이동
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if (nr<1 || nr>N || nc<1 || nc>N) break;	// 벽 부딪힘
			if (visited[nr][nc]) break;	// 자기자신과 부딪힘
			
			q.offerFirst(new int[] {nr, nc});	// 제일 앞에 넣음
			visited[nr][nc] = true;
			
			// 사과가 없을 때
			if (!board[nr][nc]) {
				int[] last = q.pollLast();
				visited[last[0]][last[1]] = false;
			} else {
				board[nr][nc] = false;
			}
			
			// 방향 전환
			if (dirInfo.containsKey(time)) {
				if (dirInfo.get(time)=='L') dir--;
				else dir++;
				if (dir<0) dir = 3;
				else if (dir==4) dir = 0;
			}
		}
		
		System.out.println(time);
	}
}
