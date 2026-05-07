import java.io.*;
import java.util.*;

public class Main {
    static int R, C, count;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        count = 0;
        map = new char[R][C];
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        if (map[0][0]!=map[R-1][C-1]) dfs(0, 0, 0, map[0][0]);

        System.out.println(count);
    }

    static void dfs(int r, int c, int cnt, char color) {
        // 총 2번 도달하면 종료
        if (cnt==2) {
            count++;
            return;
        }
        int startR = r+1;
        int startC = c+1;
        int endR = R-2;
        int endC = C-2;
        if (color=='W') color = 'B';
        else color = 'W';

        for (int i=startR; i<=endR; i++) {
            for (int j=startC; j<=endC; j++) {
                if (map[i][j]==color) dfs(i, j, cnt+1, color);
            }
        }

    }
}