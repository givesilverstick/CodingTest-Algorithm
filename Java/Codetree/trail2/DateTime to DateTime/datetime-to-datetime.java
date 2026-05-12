import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        int fix = 11*24*60 + 11*60 + 11;
        int compare = A*24*60 + B*60 + C;
        if (fix > compare) System.out.println(-1);
        else System.out.println(compare-fix);
    }
}