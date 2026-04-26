import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		char[][] board = new char[N][M];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		result = Integer.MAX_VALUE;
		
		// 8*8 시작점 찾기
		for (int i=0; i<=N-8; i++) {
			for (int j=0; j<=M-8; j++) {
				findMinChange(i, j, board);
			}
		}
		sb.append(result);
		System.out.println(sb);
	}
	
	static void findMinChange(int r, int c, char[][] board) {
		int count = 0;
		char color = board[r][c];
		
		for (int i=r; i<r+8; i++) {
			for (int j=c; j<c+8; j++) {
				
				if (board[i][j] != color) {
					count++;
				}
				// 다음 칸 색 변경 
				if (color == 'W') color = 'B';
				else color = 'W';
			}
			// 다음 줄 색 변경 
			if (color == 'W') color = 'B';
			else color = 'W';
		}
		
		count = Math.min(count, 64-count);	// 첫 시작이 반대인 거 랑 비교
		
		result = Math.min(result, count);
	}
}
