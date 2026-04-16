import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		int[] time = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = scanner.nextInt();
		}
		Arrays.sort(time);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				sum += time[j];
			}
		}
		System.out.println(sum);
	}
}