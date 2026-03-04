import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, map[][];
	static int[] dr={-1,1,0,0}, dc={0,0,-1,1};
	static boolean[][] visited;
	static List<Integer> count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new ArrayList<>();
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		//solve
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j]==1 && !visited[i][j]) {
					count.add(dfs(i, j));
				}
			}
		}
		
		count.sort((a,b)->a-b);
		System.out.println(count.size());
		for (int num : count) {
			System.out.println(num);
		}
		
	}
	
	public static int dfs(int r, int c) {
		visited[r][c] = true;
		int count = 1;
		
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]==1) {
				visited[nr][nc] = true;
				count += dfs(nr, nc);
			}
		}
		return count;
	}
}
