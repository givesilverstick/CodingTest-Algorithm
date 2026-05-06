import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[2*N];
        for (int i=0; i<2*N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int maxVal = 0;
        for (int i=0; i<N; i++) {
            int sum = nums[i]+nums[2*N-1-i];
            maxVal = Math.max(maxVal, sum);
        }
        System.out.println(maxVal);
    }
}