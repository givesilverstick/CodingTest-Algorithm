import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 계단의 수
		int[] score = new int[301];
		int[] sum = new int[301];
		for (int i=1; i<=N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		sum[1] = score[1];
		sum[2] = sum[1]+score[2];
		for (int i=3; i<=N; i++) {
			sum[i] = Math.max(sum[i-2], sum[i-3]+ score[i-1]) + score[i];
		}
		System.out.println(sum[N]);
	}
}
