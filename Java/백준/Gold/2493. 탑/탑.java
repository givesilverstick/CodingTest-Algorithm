import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
//		int[] top = new int[N+1];
//		int max = 0;
		Stack<int[]> stack = new Stack<>();
		for (int i=1; i<=N; i++) {
			// 완전탐색? -> 시간초과 
//			top[i] = Integer.parseInt(st.nextToken());
//			if (top[i] >= max) {
//				max = top[i];
//				sb.append(0).append(" ");
//			} else {
//				int prev = i;
//				while (prev>=0 && top[prev] <= top[i]) {
//					prev--;
//				}
//				sb.append(prev).append(" ");
//			}
			
			
			// 스택 이용해서 시간초과 해결
			int height = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				if (stack.peek()[0] > height) {
					sb.append(stack.peek()[1]).append(" ");
					break;
				}
				// 높이가 나보다 낮은 거 뺌 
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			
			stack.add(new int[] {height, i});
		}
		System.out.println(sb);
	}
	
}
