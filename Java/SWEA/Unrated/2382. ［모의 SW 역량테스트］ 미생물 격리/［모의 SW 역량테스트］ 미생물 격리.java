import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
 
    static class Edge implements Comparable<Edge> {
        int r, c, cnt, dir;
        Edge(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }
         
        public int compareTo(Edge o) {
            if (this.r!=o.r) return Integer.compare(this.r, o.r);
            if (this.c!=o.c) return Integer.compare(this.c, o.c);
            return Integer.compare(o.cnt, this.cnt);    // 내림차순
        }
    }
     
    static int N, M, K;
    static Edge[] edgeList;
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 셀 개수
            M = Integer.parseInt(st.nextToken());   // 격리 시간
            K = Integer.parseInt(st.nextToken());   // 미생물 군집 개수
            edgeList = new Edge[K];
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());   // 세로 위치
                int c = Integer.parseInt(st.nextToken());   // 가로 위치
                int cnt = Integer.parseInt(st.nextToken()); // 미생물 수 
                int dir = Integer.parseInt(st.nextToken()); // 이동 방향 (상: 1, 하: 2, 좌: 3, 우: 4)
                edgeList[i] = new Edge(r, c, cnt, dir);
            }
             
             
            for (int t=0; t<M; t++) {
                // 미생물 군집 이동
                for (int i=0; i<K; i++) {
                    if (edgeList[i].cnt>0) move(i);
                }
                // 합치기
                Arrays.sort(edgeList);  // 정렬
                for (int i=0; i<K; i++) {
                    int j = i+1;
                    while(j<K && edgeList[i].r==edgeList[j].r && edgeList[i].c==edgeList[j].c) {
                        edgeList[i].cnt += edgeList[j].cnt;
                        edgeList[j].cnt = 0;
                        j++;
                    }
                    i = j-1;
                }
            }
             
            int result = 0;
            for (int i=0; i<K; i++) {
                if (edgeList[i].cnt>0) {
                    result += edgeList[i].cnt;
                }
            }
             
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
     
    static void move(int idx) {
        Edge cur = edgeList[idx];
        switch(cur.dir) {
        case 1:
            if (cur.r > 0) cur.r--;
            break;
        case 2:
            if (cur.r < N-1) cur.r++;
            break;
        case 3:
            if (cur.c > 0) cur.c--;
            break;
        case 4:
            if (cur.c < N-1) cur.c++;
            break;
        }
         
        // 약품 칠해진 셀 도착
        if (cur.r == 0 || cur.r == N-1 || cur.c == 0 || cur.c == N-1) {
            cur.cnt = (int) Math.floor(cur.cnt/2);  // 절반 죽기 
            // 이동 방향 변경
            switch(cur.dir) {
            case 1:
                cur.dir = 2;
                break;
            case 2:
                cur.dir = 1;
                break;
            case 3:
                cur.dir = 4;
                break;
            case 4:
                cur.dir = 3;
                break;
            }
        }
    }
}