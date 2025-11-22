
import java.util.*;
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
            System.out.print("#"+test_case+" ");
            String str = sc.next();
            String bit = "";
            String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
            

            for (int i=0; i<str.length(); i++) {
                int val = base.indexOf(str.charAt(i));
                bit += toBit(val);
            }
            for (int i=0; i<bit.length(); i+=8) {
                System.out.print((char) toInt(bit.substring(i,i+8)));
            }
            System.out.println();
		}
	}
    
    public static String toBit(int num) {
        String str = "";
        for (int n = num; n>0; n/=2) {
            str = (n%2) + str;
        }
        while (str.length() < 6) str = "0" + str;
        return str;
    }
    public static int toInt(String bit) {
        int num = 0;
        for (int i=0; i<8; i++) {
            num += (bit.charAt(i)-'0') * Math.pow(2,7-i);
        }
        return num;
    }
}