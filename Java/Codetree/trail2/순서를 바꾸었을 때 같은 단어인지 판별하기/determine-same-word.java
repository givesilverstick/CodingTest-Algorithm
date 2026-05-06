import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        word1 = new String(char1);
        word2 = new String(char2);
        if (word1.equals(word2)) System.out.println("Yes");
        else System.out.println("No");
    }
}