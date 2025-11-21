
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        for (int t=1; t<=10; t++) {
            int T = sc.nextInt();
            int[] buildings = new int[T];
            System.out.print("#"+t+" ");
            
            for(int test_case = 0; test_case < T; test_case++) {
                buildings[test_case] = sc.nextInt();
            }
            
            int count = 0;
            for (int i=2; i<T-2; i++) {
            	int max = Math.max(Math.max(buildings[i-2], buildings[i-1]), Math.max(buildings[i+1], buildings[i+2]));
                if (buildings[i] > max) count += buildings[i]-max;
            }
            System.out.println(count);
        }
	}
}