import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 자연수
		int count = 0;
		
		// 한수의 개수?
		// 한수 : 각 자리가 등차수열인 수
		for (int i=1; i<=N; i++) {
			if (check(i)) count++;
		}
		
		System.out.println(count);
	}
	
	public static boolean check(int num) {
		if (num < 100) return true;
		
		int hun = num/100;
		int ten = (num/10)%10;
		int one = num%10;
		
		if ((hun-ten) == (ten-one)) return true;
		
		return false;
	}
}

