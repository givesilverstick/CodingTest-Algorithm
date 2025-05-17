import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // col
        int m = sc.nextInt(); // row

        String line = "*";
        for (int i=1; i<n; i++) {
            line += "*";
        }
        for (int i=0; i<m; i++) {
            System.out.println(line);
        }
    }
}