import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			char[] nums = new char[N];
			for (int i=0; i<N; i++) {
				nums[i] = str.charAt(i);
			}
			
			Set<String> set = new HashSet<>();
			for (int i=0; i<N/4; i++) {
				for (int j=0; j<4; j++) {
					set.add(str.substring(j*N/4, (j+1)*N/4));
				}
				str = str.charAt(str.length()-1) + str.substring(0,str.length()-1);
			}
            List<String> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder()); // 내림차순
            sb.append("#").append(tc).append(" ").append(Integer.parseInt(list.get(K-1), 16)).append("\n");
		}
		System.out.println(sb);
	}
}
