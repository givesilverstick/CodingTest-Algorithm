import java.util.*;

class Mem {
    public int memAge;
    public String memName;
    
    public Mem(int age, String name) {
        this.memAge = age;
        this.memName = name;
    }
    
    public String toString() {
    	return memAge+" "+memName;
    }
}

public class Main {

public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int N = scanner.nextInt();
        Mem[] m = new Mem[N];
        for (int i = 0; i < N; i++) {
            int age = scanner.nextInt();
            String name = scanner.next();
            m[i] = new Mem(age, name);
        }
        Arrays.sort(m, new Comparator<Mem>() {
        	public int compare(Mem m1, Mem m2) {
        		return m1.memAge - m2.memAge;
        	}
        });
        
        for(int i=0; i < N; i++) {
        	System.out.println(m[i]);
        }
    }

}