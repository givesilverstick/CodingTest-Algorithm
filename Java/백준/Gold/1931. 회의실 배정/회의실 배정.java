import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 회의 수
		int[][] conference = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			conference[i][0] = Integer.parseInt(st.nextToken());
			conference[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(conference, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
		
		int count = 0;
		int prevEndTime = 0;
		// 혼자 다시 
		for (int i=0; i<N; i++) {
			if (conference[i][0] >= prevEndTime) {
				prevEndTime = conference[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
