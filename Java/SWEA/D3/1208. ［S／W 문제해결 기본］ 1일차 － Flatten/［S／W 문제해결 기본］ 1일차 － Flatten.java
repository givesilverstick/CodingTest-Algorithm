
import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        for (int t=1; t<=10; t++) {
            int T;
            T=sc.nextInt();
            System.out.print("#"+t+" ");
            int[] arr = new int[100];
            for(int test_case = 0; test_case < 100; test_case++) {
                arr[test_case] = sc.nextInt();
            }
            
            for (int i=0; i<T; i++) {
                Arrays.sort(arr);
                // System.out.println(arr[0] + " ... "+arr[99]);
                if (arr[99] > arr[0]) {
                    arr[99]--;
                    arr[0]++;
                }
                else if (arr[99] == arr[0]) break;
            }
            Arrays.sort(arr);
            System.out.println(arr[99]-arr[0]);
        }
	}
}