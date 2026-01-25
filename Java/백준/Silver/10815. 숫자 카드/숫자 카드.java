import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
		Set<Integer> card1 = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			card1.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> card2 = new ArrayList<Integer>();
		for (int i=0; i<M; i++) {
			card2.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i=0; i<M; i++) {
			int num = card2.get(i);
			if (card1.contains(num)) System.out.print(1);
			else System.out.print(0);
			System.out.print(" ");
		}
	}

}
