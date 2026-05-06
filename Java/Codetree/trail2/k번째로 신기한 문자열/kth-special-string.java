import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String T = st.nextToken();

        List<String> words = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String word = br.readLine();
            if (word.startsWith(T)) words.add(word);
        }
        Collections.sort(words);
        System.out.println(words.get(K-1));
    }
}