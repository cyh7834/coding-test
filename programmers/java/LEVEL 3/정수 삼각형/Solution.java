public static int solution(int[][] triangle) {
        int triangleHeight = triangle.length;
        int[][] memo = new int[triangleHeight][];
        memo[0] = new int[]{triangle[0][0]};

        for (int i = 1; i < triangleHeight; i++) {
            int width = triangle[i].length;
            memo[i] = new int[width];

            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    memo[i][j] = memo[i - 1][j] + triangle[i][j];
                }
                else if (j == width - 1) {
                    memo[i][j] = memo[i - 1][j - 1] + triangle[i][j];
                }
                else {
                    memo[i][j] = Math.max(memo[i - 1][j - 1] + triangle[i][j], memo[i - 1][j] + triangle[i][j]);
                }
            }

        }

        return Arrays.stream(memo[triangleHeight - 1]).max().getAsInt();
    }