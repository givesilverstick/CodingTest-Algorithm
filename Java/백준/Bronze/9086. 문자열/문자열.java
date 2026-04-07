import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			String line = br.readLine();
			sb.append(line.charAt(0));
			if (line.length()==1) sb.append(line.charAt(0));
			else sb.append(line.charAt(line.length()-1));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
