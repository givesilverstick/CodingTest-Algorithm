import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			int left = 0;
			int right = N-1;
			while (left < right) {
				int sum = arr[left]+arr[right];
				if (sum==arr[i]) {
					if (left == i) {
						left++;
					} else if (right  == i) {
						right--;
					} else {
						cnt++;
						break;
					}
				} else if (sum > arr[i]) {
					right--;
				} else {
					left++;
				}
			}
		}
		System.out.println(cnt);
	}
}
