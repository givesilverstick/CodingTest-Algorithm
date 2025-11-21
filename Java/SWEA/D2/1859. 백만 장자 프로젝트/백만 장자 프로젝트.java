import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			System.out.print("#" + test_case);
            int day = sc.nextInt();
            long maxPrice = Integer.MIN_VALUE;
            long sum = 0;
            int[] nums = new int[day];
            for (int d=0; d<day; d++) {
                nums[d] = sc.nextInt();
            }
            for (int d=day-1; d>=0; d--) {
                if (nums[d] > maxPrice) maxPrice = nums[d];
                else {
                    sum += (maxPrice-nums[d]);
                }
            }
            if (sum < 0) sum = 0;
            System.out.println(" " + sum);

		}
	}
}