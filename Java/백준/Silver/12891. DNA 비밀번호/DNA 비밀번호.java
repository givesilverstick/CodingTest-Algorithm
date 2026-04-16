import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int idx(char c) {
	    switch (c) {
	        case 'A': return 0;
	        case 'C': return 1;
	        case 'G': return 2;
	        case 'T': return 3;
	        default: return -1;
	    }
	}
	
	static boolean check(int[] need, int[] count) {
		for (int i=0; i<4; i++) {
			if (count[i] < need[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		
		int sLength = Integer.parseInt(st.nextToken());
		int pLength = Integer.parseInt(st.nextToken());
		String tempDNAStr = br.readLine();
		int[] need = new int[4];
		int[] count = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			need[i] = Integer.parseInt(st.nextToken());
		}
		// 초기 윈도우
		for (int i=0; i<pLength; i++) {
			count[idx(tempDNAStr.charAt(i))]++;
		}
		if (check(need, count)) result++;
		
		for (int i=pLength; i<sLength; i++) {
			count[idx(tempDNAStr.charAt(i))]++;	// 오른쪽 더하기
			count[idx(tempDNAStr.charAt(i-pLength))]--; // 왼쪽 빼기
			if (check(need, count)) result++;
		}
		System.out.println(result);
	}
}
