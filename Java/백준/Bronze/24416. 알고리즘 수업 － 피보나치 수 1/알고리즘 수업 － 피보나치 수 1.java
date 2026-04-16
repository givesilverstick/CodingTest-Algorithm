import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		System.out.print(fib(n) + " ");
		System.out.println(fibonacci(n));
		
	}

	static int count_fib = 0;
	public static int fib(int n) {
	    if (n == 1 || n == 2) {
//	    	return 1;  // 코드1
	    	count_fib += 1;
	    }
	    else {
	    	fib(n-1);
	    	fib(n-2);
	    }
	    return count_fib;
	}
	
	public static int fibonacci(int n) {
		int[] f = new int[n+1];
	    f[1] = 1;
	    f[2] = 1;
	    int count = 0;
	    for (int i = 3; i <= n; i++) {
	    	f[i] = f[i - 1] + f[i - 2];  // 코드2
	    	count += 1;
	    }
	    return count;
	}
}
