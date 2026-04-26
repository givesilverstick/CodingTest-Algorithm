import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int X = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		list.add(64);
		
		while (true) {
			int sum = 0;
			for (int n : list) sum += n;
			
			if (sum == X) break;
			
			Collections.sort(list);
			int shortest = list.remove(0);
			int half = shortest / 2;
			int curSum = 0;
			for (int n : list) curSum += n;
			
			if (curSum+half < X) list.add(half);
			list.add(half);
			
		}
		
		sb.append(list.size());
		System.out.println(sb);
	}
	
	
}
