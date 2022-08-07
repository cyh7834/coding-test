import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public int bfs(int[][] maps) {
        int rowLength = maps.length;
        int colLength = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visit = new int[rowLength][colLength];
        visit[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] index = queue.poll();

            if (index[0] == rowLength - 1 && index[1] == colLength - 1)
                return visit[index[0]][index[1]];

            if (index[1] + 1 < colLength && maps[index[0]][index[1] + 1] == 1 && visit[index[0]][index[1] + 1] == 0) {
                queue.add(new int[]{index[0], index[1] + 1});
                visit[index[0]][index[1] + 1] = visit[index[0]][index[1]] + 1;
            }

            if (index[0] + 1 < rowLength && maps[index[0] + 1][index[1]] == 1 && visit[index[0] + 1][index[1]] == 0) {
                queue.add(new int[]{index[0] + 1, index[1]});
                visit[index[0] + 1][index[1]] = visit[index[0]][index[1]] + 1;
            }

            if (index[0] - 1 > -1 && maps[index[0] - 1][index[1]] == 1 && visit[index[0] - 1][index[1]] == 0) {
                queue.add(new int[]{index[0] - 1, index[1]});
                visit[index[0] - 1][index[1]] = visit[index[0]][index[1]] + 1;
            }

            if (index[1] - 1 > -1 && maps[index[0]][index[1] - 1] == 1 && visit[index[0]][index[1] - 1] == 0) {
                queue.add(new int[]{index[0], index[1] - 1});
                visit[index[0]][index[1] - 1] = visit[index[0]][index[1]] + 1;
            }

        }

        return -1;
    }
}