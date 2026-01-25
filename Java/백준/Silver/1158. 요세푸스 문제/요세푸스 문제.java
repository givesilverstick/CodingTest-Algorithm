import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=N; i++) {
			list.add(i);
		}
		
		List<Integer> remove = new ArrayList<Integer>();
		int idx = K-1;
		
		while (!list.isEmpty()) {
			idx = idx % list.size();
			remove.add(list.get(idx));
			list.remove(idx);
			idx += K-1;
		}
		System.out.print("<");
		for (int i=0; i<remove.size(); i++) {
			System.out.print(remove.get(i));
			if (i!=remove.size()-1) System.out.print(", ");
		}
		System.out.print(">");
	}
}
