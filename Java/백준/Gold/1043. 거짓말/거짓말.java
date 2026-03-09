import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int trueCnt, come[][];
	static boolean[] checked, visited;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 사람의 수
		int M = Integer.parseInt(st.nextToken());	// 파티의 수 
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());	// 진실을 아는 사람의 수
		Set<Integer> know = new HashSet<>();
		for (int i=0; i<K; i++) {
			know.add(Integer.parseInt(st.nextToken()));
		}
		come = new int[M][];	// 파티별 오는 사람 번호
		list = new ArrayList[N+1];	// 사람별 가는 파티 번호
		for (int i=1; i<=N; i++) list[i] = new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());	// 각 파티에 오는 사람의 수 
			come[i] = new int[P];
			for (int j=0; j<P; j++) {
				int num = Integer.parseInt(st.nextToken());
				come[i][j] = num;
				list[num].add(i);
			}
		}
		
		/*
		 * 진실 < 과장
		 * 진실 아는 사람 포함 -> 진실 얘기
		 */
		checked = new boolean[N+1];	// 사람 체크
		visited = new boolean[M];	// 파티 체크
		trueCnt= 0;
		if (K == 0) trueCnt = 0;
		else {
			for (int i=1; i<=N; i++) {
				if (know.contains(i)) {
					if (!checked[i]) dfs(i);
				}
			}
		}
		System.out.println(M-trueCnt);
	}
	public static void dfs(int num) {
		checked[num] = true;
		
		for (int i=0; i<list[num].size(); i++) {
			int partyNum = list[num].get(i);
			if (visited[partyNum]) continue;
			visited[partyNum] = true;
			trueCnt++;
			for (int j=0; j<come[partyNum].length; j++) {
				if (checked[come[partyNum][j]]) continue;
				dfs(come[partyNum][j]);
			}
		}
	}
}
