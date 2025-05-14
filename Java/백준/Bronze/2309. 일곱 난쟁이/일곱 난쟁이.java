import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] heights = new int[9];
        int sum = 0;
        int notSelectedFirst = -1;
        int notnotSelectedSecond = -1;
        
        for (int i=0; i<9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }
        
        // 제외할 2명
        outer: for (int i=0; i<8; i++) {
            for (int j=i+1; j<9; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    notSelectedFirst = i;
                    notnotSelectedSecond = j;
                    break outer;
                }
            }
        }
        
        // 7명
        List<Integer> selected = new ArrayList<>();
        for (int i=0; i<9; i++) {
            if (i != notSelectedFirst && i != notnotSelectedSecond) {
                selected.add(heights[i]);
            }
        }
        Collections.sort(selected);
        
        for (int h: selected) {
            System.out.println(h);
        }
    }
}