import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, arr[][], len, result[];
	static boolean visited[], checked[];
	static List<Integer> resultList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[2][N];
		len = 0;
		resultList = new ArrayList<>();
		for (int i=0; i<N; i++) {
			arr[0][i] = i+1;
			arr[1][i] = Integer.parseInt(br.readLine());
		}
		visited = new boolean[N+1];
		for (int i=1; i<=N; i++) {
			visited[i] = true;
			dfs(i,i);
			visited[i] = false;
		}
		System.out.println(resultList.size());
		for (int n : resultList) {
			System.out.println(n);
		}
	}
	
	static void dfs(int idx, int target) {
		int next = arr[1][idx-1];
		if (!visited[next]) {
			visited[next] = true;
			dfs(next, target);
			visited[next] = false;
		} else {
			if (next == target) {
				resultList.add(target);
			}
		}
		
	}
}
