import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], count, result;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static boolean[][] visited;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		map = new int[N][M];
		visited = new boolean[N][M];
		count = result = 0;
		list = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 0:빈 칸, 1: 벽, 2: 바이러스O
				if (map[i][j]==0) count++;
				if (map[i][j]==2) list.add(new int[] {i,j});
			}
		}
		
		// 안전 영역 크기 최댓값?
		
		// 1. 벽 3개 세우기 -> 조합
		combination(0, 0);
		// 2. 안전 영역 확인
		System.out.println(result);
		
	}
	
	// 벽 세우기
	static void combination(int cnt, int start) {
		if (cnt==3) {
			int[][] copyMap = new int[N][M];
	        for (int i = 0; i < N; i++) {
	        	copyMap[i] = map[i].clone();
	        }
			// bfs
			result = Math.max(result, (count-3)-bfs(copyMap));
			return;
		}
		
		
		for (int i=start; i<N*M; i++) {
			int r = i/M;
			int c = i%M;
			if (map[r][c]!=0) continue;
			
			map[r][c] = 1;
			combination(cnt+1, i+1);
			map[r][c] = 0;
		}
	}
	
	// 바이러스 퍼지고, 바뀐영역 카운트
	static int bfs(int[][] copyMap) {
		Queue<int[]> queue = new ArrayDeque<>();
		int changeCnt = 0;
		
		for (int[] cur : list) {
			queue.offer(cur);
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if (copyMap[nr][nc]==0) {
					queue.offer(new int[] {nr,nc});
					copyMap[nr][nc] = 2;
					changeCnt++;
				}
			}
		}
		return changeCnt;
	}
}
