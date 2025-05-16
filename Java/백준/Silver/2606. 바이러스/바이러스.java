import java.util.*;

// 메모리 초과 오류(원인: 2차 배열 사용)로 틀림(직접 풀이 X)
public class Main {
    static int count = 0;
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 컴퓨터 수: 0 < N <= 100 (int)
        int M = sc.nextInt(); // 연결된 쌍 수
        
        graph = new ArrayList[N+1]; // 1번 ~ N+1번
        visited = new boolean[N+1];
        
        // 인접 리스트 초기화
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 입력 받아 인접 리스트 구성
        for (int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a); // 무방향 그래프
        }
        
        dfs(1);
        
        // graph = ArrayList[8]
        // graph[i] = ArrayList[]
        // => graph[8][]
        
        // graph[1] = 2 5
        // graph[2] = 1 3 5
        // graph[3] = 2
        // graph[4] = 7
        // graph[5] = 1 2 6
        // graph[6] = 5
        // graph[7] = 4
        
        // 1번 컴퓨터 제외하고 감염된 수만 출력
        System.out.println(count - 1);
        
    }
    
    static void dfs(int node) {
        visited[node] = true;
        count++;
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}