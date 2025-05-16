import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    
    static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int[] dy = {0, 1, -1, 0, 1, -1, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    map[i][j]=sc.nextInt();
                }
            }

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (map[i][j]==1 && !visited[i][j]) {
                        dfs(i,j);
                        count++; // 메인 실수 부분 (dfs에서 카운트함)
                    }
                }
            }
            
            System.out.println(count);
        }
    }
    
    static void dfs(int x, int y) {
                visited[x][y] = true;

                for (int d=0; d<8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx>=0 && ny>=0 && nx<h && ny<w) {
                        if (map[nx][ny]== 1 && !visited[nx][ny]) {
                            dfs(nx, ny);
                        }
                    }
                }
            }
}