import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N][N];
        int roadRow = road.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < roadRow; i++) {
            map[road[i][0] - 1][road[i][1] - 1] = Math.min(road[i][2], map[road[i][0] - 1][road[i][1] - 1]);
            map[road[i][1] - 1][road[i][0] - 1] = Math.min(road[i][2], map[road[i][1] - 1][road[i][0] - 1]);
        }

        bfs(N, map);

        for (int i = 0; i < N; i++) {
            if (map[0][i] <= K)
                answer++;
        }

        return answer;
    }

    public void bfs(int N, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] currentIndex = queue.poll();

            for (int i = 0; i < N; i++) {
                if (i == currentIndex[0])
                    continue;

                if (map[currentIndex[0]][i] != Integer.MAX_VALUE &&
                        map[0][i] >= map[currentIndex[0]][i] + currentIndex[1]) {

                    map[0][i] = map[currentIndex[0]][i] + currentIndex[1];
                    queue.add(new int[]{i, map[currentIndex[0]][i] + currentIndex[1]});
                }
            }
        }
    }
}