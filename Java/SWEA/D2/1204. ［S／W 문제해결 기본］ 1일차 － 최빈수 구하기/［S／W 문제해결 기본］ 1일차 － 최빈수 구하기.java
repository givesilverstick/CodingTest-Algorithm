
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
            int caseNum = sc.nextInt();
            System.out.print("#"+caseNum);
            int[] count = new int[101];
            for (int student=0; student<1000; student++) {
                int score = sc.nextInt();
                count[score]++;
            }
            int answerCount = 0;
            int answerScore = 0;
            for (int i=0; i<=100; i++) {
                if (count[i] >= answerCount) {
                    answerCount = count[i];
                    answerScore = i;
                }
            }
             System.out.println(" "+answerScore);
		}
	}
}