import java.util.*;

public static int solution(int n, int[][] edge) {
        int answer = 0;
        int numberOfEdge = edge.length;
        int[] moveCount = new int[n];
        moveCount[0] = 0;
        for (int i = 1; i < n; i++)
            moveCount[i] = -1;

        boolean[][] graph = new boolean[n][n];

        setGraph(edge, numberOfEdge, graph);
        bfs(graph, moveCount);

        int max = Arrays.stream(moveCount)
                .max()
                .getAsInt();

        for (int i = 0; i < n; i++) {
            if (moveCount[i] == max)
                answer++;
        }

        return answer;
    }

    private static void bfs(boolean[][] graph, int[] moveCount) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[moveCount.length];
        visit[0] = true;
        queue.add(0);

        while(!queue.isEmpty()) {
            int currentIndex = queue.poll();

            for (int i = 0; i < graph[currentIndex].length; i++) {
                if (!visit[i] && graph[currentIndex][i]) {
                    queue.add(i);
                    visit[i] = true;
                    moveCount[i] = moveCount[currentIndex] + 1;
                }
            }
        }
    }

    private static void setGraph(int[][] edge, int numberOfEdge, boolean[][] graph) {
        for (int i = 0; i < numberOfEdge; i++) {
            graph[edge[i][0] - 1][edge[i][1] - 1] = true;
            graph[edge[i][1] - 1][edge[i][0] - 1] = true;
        }
    }