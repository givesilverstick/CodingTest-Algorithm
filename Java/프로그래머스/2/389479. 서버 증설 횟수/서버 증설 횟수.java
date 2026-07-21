class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] addedServers = new int[players.length];

        for (int time = 0; time < players.length; time++) {
            // 현재 시간에 운영 중인 증설 서버 수
            int activeServers = 0;

            for (int start = Math.max(0, time - k + 1); start <= time; start++) {
                activeServers += addedServers[start];
            }

            // 현재 이용자 수를 처리하기 위해 필요한 증설 서버 수
            int requiredServers = players[time] / m;

            if (requiredServers > activeServers) {
                int newServers = requiredServers - activeServers;

                addedServers[time] = newServers;
                answer += newServers;
            }
        }

        return answer;
    }
}