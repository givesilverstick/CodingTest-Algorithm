import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], M, minD;
	static int selected[];
	static List<int[]> house, chicken;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 도시 크기 N*N
		map = new int[N][N];
		M = Integer.parseInt(st.nextToken());	// 최대 치킨집 수
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 0은 빈 칸, 1은 집, 2는 치킨집
				if (map[i][j]==1) house.add(new int[] {i,j});
				else if (map[i][j]==2) chicken.add(new int[] {i,j});
			}
		}
		minD = Integer.MAX_VALUE;
		selected = new int[M];	// 고른 치킨집 인덱스 번호
		dfs(0, 0);
		System.out.println(minD);
	}
	
	// 조합
	public static void dfs(int cnt, int idx) {
		// 치킨집: ?개 중 M개 뽑음!
		if (cnt==M) {
			int sum = 0;
			for (int i=0; i<house.size(); i++) {
				int dis = Integer.MAX_VALUE;
				for (int j=0; j<M; j++) {
					dis = Math.min(dis, distance(house.get(i),chicken.get(selected[j])));
				}
				sum += dis;
			}
			minD = Math.min(minD, sum);
			return;
		}
		if (idx >= chicken.size()) return;
		
		selected[cnt] = idx;
		dfs(cnt+1, idx+1);	// 뽑는 경우
		selected[cnt] = 0;
		dfs(cnt, idx+1);	// 안 뽑는 경우
	}
	
	public static int distance(int[] house, int[] chicken) {
		return Math.abs(house[0]-chicken[0])+Math.abs(house[1]-chicken[1]);
	}
}
