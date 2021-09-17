class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        map[0][0] = 1;

        for (int[] puddle : puddles)
            map[puddle[1] - 1][puddle[0] - 1] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (map[i][j] != -1) {
                    int count = 0;

                    if (i == 0)
                        count = map[i][j - 1] == -1 ? 0 : map[i][j - 1];
                    else if (j == 0)
                        count = map[i - 1][j] == -1 ? 0 : map[i - 1][j];
                    else {
                        int top = map[i - 1][j] == -1 ? 0 : map[i - 1][j];
                        int left = map[i][j - 1] == -1 ? 0 : map[i][j - 1];
                        count = top + left;
                    }
                    map[i][j] = count % 1000000007;
                }
            }
        }

        return map[n - 1][m - 1] % 1000000007;
    }
}