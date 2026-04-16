import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int H = scanner.nextInt();
        int M = scanner.nextInt();
        int start = H * 60 + M;
        int time = scanner.nextInt();
        int end = start + time;
        H = end/60;
        M = end%60;
        System.out.println(H%24 + " " + M);
    }
}