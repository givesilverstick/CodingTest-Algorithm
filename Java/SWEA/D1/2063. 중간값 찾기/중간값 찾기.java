
import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] arr = new int[T];

		for(int test_case = 0; test_case < T; test_case++)
		{
            arr[test_case] = sc.nextInt();
		}
        Arrays.sort(arr);
        int idx = (int) Math.ceil(T/2);
        System.out.println(arr[idx]);
	}
}