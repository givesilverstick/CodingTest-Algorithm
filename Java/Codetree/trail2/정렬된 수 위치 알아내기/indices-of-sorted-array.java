import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        int[] result = new int[N];
        for (int i=0; i<N; i++) result[arr[i][1]] = i+1;
                
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) sb.append(result[i]).append(" ");
        sb.append("\n");
        System.out.println(sb);
    }
}