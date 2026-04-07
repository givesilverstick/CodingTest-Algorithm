import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int pCnt, selectedStair[], result, person[][], stair[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			// 사람의 수 1~10
			// 계단의 수 2개. 고정
			// => 2^(사람수)
			pCnt = 0;	// 사람 수
			person = new int[10][2];	// r,c
			int sCnt = 0;	// 계단 수
			stair = new int[2][3];	// r,c, len
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j]==1) {
						person[pCnt][0] = i;
						person[pCnt++][1] = j;
					} else if (map[i][j]>1) {
						stair[sCnt][0] = i;
						stair[sCnt][1] = j;
						stair[sCnt++][2] = map[i][j];
					}
				}
			}
			
			selectedStair = new int[pCnt];
			result = Integer.MAX_VALUE;
			
			// 각 사람마다 두 계단 중 하나 선택하여 이동 -> 계단 내려가기 -> 완료.... (시뮬 돌리기 시간별로)
			dfs(0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	// 먼저 사람들이 각각 이동할 계단을 고르기
	static void dfs(int cnt) {
		if (cnt == pCnt) {
			// 계단 내려가기
			result = Math.min(result, run());
			return;
		}
		
		selectedStair[cnt] = 0;
		dfs(cnt+1);
		
		selectedStair[cnt] = 1;
		dfs(cnt+1);
	}
	
	// 고른 계단으로 시뮬 돌리기
	static int run() {
		
		List<Integer> group0 = new ArrayList<>();
		List<Integer> group1 = new ArrayList<>();
		
		// 계단 이동
		for (int i=0; i<pCnt; i++) {
			int dist = Math.abs(person[i][0]-stair[selectedStair[i]][0]) + Math.abs(person[i][1]-stair[selectedStair[i]][1]);
			if (selectedStair[i]==0) group0.add(dist);
			else group1.add(dist);
		}
		
		int time0 = calTime(0, group0);
		int time1 = calTime(1, group1);
		
		return Math.max(time0, time1);
	}
	
	// 완료 시간 계산하기
	static int calTime(int groupId, List<Integer> arriveTimes) {
		Collections.sort(arriveTimes);
		
		Queue<Integer> q = new ArrayDeque<>();
		
		int endTime = 0;
		for (int arriveTime : arriveTimes) {
			
			int entryTime = arriveTime+1;	// 진입시간: 도착하고 1분 후에 내려 갈 수 있음.
			
			// 3명까지 계단 이용 가능
			if (q.size()==3) {
				int cur = q.poll();
				if (cur > entryTime) entryTime = cur;
			}
			int finishTime = entryTime+stair[groupId][2];
			q.offer(finishTime);
			endTime = finishTime;
		}
		return endTime;
	}
}
