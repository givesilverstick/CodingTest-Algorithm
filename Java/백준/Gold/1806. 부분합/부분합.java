import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0, e = 0, sum = 0;
		int minLen = INF;
		
		while (true) {
			if (sum >= S) {
				minLen = Math.min(minLen, e-s);
				sum -= arr[s++];
			} else if (e==N) {
				break;
			} else {
				sum += arr[e++];
			}
		}
		
		System.out.println(minLen==INF ? 0 : minLen);
	}
}
