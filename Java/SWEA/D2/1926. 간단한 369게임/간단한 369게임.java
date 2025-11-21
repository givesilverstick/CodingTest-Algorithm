
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
            boolean isClap = false;
            int count = 0;
            for (int num=test_case; num>0; num/=10) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    isClap = true;
                    count++;
                }
            }
            if (isClap) {
                for (int i=0; i<count; i++) {
                    System.out.print("-");
                }
            }
			else System.out.print(test_case);
            System.out.print(" ");

		}
	}
}