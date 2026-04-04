import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static char[][] map;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		count = new int[6];
		for (int i=0; i<12; i++) {
			String line = br.readLine();
			for (int j=0; j<6; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j]!='.') count[j]++;
			}
		}
		
		
		int result = 0;
		while (true) {
			boolean bomb = false;
			for (int i=11; i>=0; i--) {
				for (int j=5; j>=0; j--) {
					if (map[i][j]!='.' ) {
						int[] temp = new int[] {i,j};
						if (bfs(temp)) bomb = true;
					}
				}
			}
			
			// 중력
			if (bomb) {
				for (int j=0; j<6; j++) {
					List<Character> list = new ArrayList<>();
					for (int i=11; i>=0; i--) {
						if (map[i][j]!='.') {
							list.add(map[i][j]);
							map[i][j] = '.';
						}
						if (list.size()==count[j]) break;
					}
					for (int i=0; i<list.size(); i++) {
						map[11-i][j] = list.get(i);
					}
				}
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);
	}
	
	static boolean bfs(int[] temp) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[12][6];
		List<int[]> list = new ArrayList<>();
		
		q.offer(temp);
		list.add(temp);
		visited[temp[0]][temp[1]] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d=0; d<4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if (nr<0 || nr>=12 || nc<0 || nc>=6 || visited[nr][nc]) continue;
				if (map[nr][nc]==map[cur[0]][cur[1]]) {
					q.offer(new int[] {nr,nc});
					list.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		// bomb
		if (list.size()>=4) {
			for (int[] cur : list) {
				map[cur[0]][cur[1]] = '.';
				count[cur[1]]--;
			}
			return true;
		}
		return false;
	}
}
