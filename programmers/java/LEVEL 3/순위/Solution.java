class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = createGraph(n, results);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (graph[j][i] == 2) {
                    for (int k = 0; k < n; k++) {
                        if (graph[i][k] == 2)
                            graph[j][k] = 2;
                    }
                }
                else if (graph[j][i] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (graph[i][k] == 1)
                            graph[j][k] = 1;
                    }
                }
                else {
                    for (int k = 0; k < n; k++) {
                        if (graph[j][k] == 2 && graph[i][k] == 1)
                            graph[j][i] = 2;
                        else if (graph[j][k] == 1 && graph[i][k] == 2)
                            graph[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean ranked = true;

            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] == 0) {
                    ranked = false;
                    break;
                }
            }

            if (ranked)
                answer++;
        }

        return answer;
    }

    private int[][] createGraph(int n, int[][] results) {
        int[][] graph = new int[n][n];
        int resultLength = results.length;

        for (int i = 0; i < resultLength; i++) {
            graph[results[i][0] - 1][results[i][1] - 1] = 2;
            graph[results[i][1] - 1][results[i][0] - 1] = 1;
        }

        return graph;
    }
}