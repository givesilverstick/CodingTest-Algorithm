import java.util.*;

// DFS 문제 감 익히는 용 (직접 풀기X)
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count; // 단지 내 집 수 카운트용
    
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i=0; i<N; i++) {
            String line = sc.next(); // 한 줄 입력받기
            for (int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자 -> 숫자
            }
        }
        
        List<Integer> groupSizes = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i,j);
                    groupSizes.add(count);
                }
            }
        }
        
        Collections.sort(groupSizes); // 오름차순 정렬
        System.out.println(groupSizes.size());
        for (int size : groupSizes) {
            System.out.println(size);
        }
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        
        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx>=0 && ny>=0 && nx<N && ny<N) {
                if (map[nx][ny]==1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}