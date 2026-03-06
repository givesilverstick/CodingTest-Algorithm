import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, price[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 끊어진 기타줄 수
		M = Integer.parseInt(st.nextToken());	// 브랜드 수
		price = new int[M][2];	// 브랜드 별 가격: {패키지가격, 낱개가격}
		int minPackage = Integer.MAX_VALUE;
		int minNotPackage = Integer.MAX_VALUE;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			price[i][0] = Integer.parseInt(st.nextToken());	// 패키지(6개)가격 
			price[i][1] = Integer.parseInt(st.nextToken());	// 낱개(1개)가격
			minPackage = Math.min(minPackage, price[i][0]);
			minNotPackage = Math.min(minNotPackage, price[i][1]);
		}
		int min = Integer.MAX_VALUE;
		int pCnt = N%6==0 ? N/6 : N/6+1;
		int sum = 0;
		while (pCnt>=0) {
			sum = pCnt * minPackage;
			if (N > pCnt*6) sum += (N-pCnt*6)*minNotPackage;
			pCnt--;
			min = Math.min(min, sum);
		}
		
		System.out.println(min);
	}
}

