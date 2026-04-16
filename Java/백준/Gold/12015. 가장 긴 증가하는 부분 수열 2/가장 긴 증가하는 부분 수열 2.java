import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num1 = scanner.nextInt();
 		int[] A = new int[num1];
		for (int i = 0; i < num1; i++) {
			int n = scanner.nextInt();
			A[i] = n;
		}
        int length = longestIncreasing(A);
        System.out.println(length);
    }
    
    public static int longestIncreasing(int[] A) {
        int n = A.length;
        int[] lis = new int[n];
        lis[0] = A[0];
        int length = 1;
        
        for (int i = 1; i < n; i++) {
            if (A[i] > lis[length - 1]) {
                lis[length++] = A[i];
            } else {
                int index = Arrays.binarySearch(lis, 0, length - 1, A[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                lis[index] = A[i];
            }
        }
        
        return length;
    }
}
