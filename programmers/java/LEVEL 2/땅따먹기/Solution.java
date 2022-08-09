class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int[][] memo = new int[land.length][4];
        
        dfs(land, memo, 0);

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, memo[0][i]);
        }
        
        return answer;
    }

    public void dfs(int[][] land, int[][] memo, int row) {
        int rowLength = land.length;
        if (row + 1 == rowLength) {
            for (int i = 0; i < 4; i++) {
                memo[row][i] = land[row][i];
            }

            return;
        }

        dfs(land, memo, row + 1);

        for (int i = 0; i < 4; i++) {
            int max = getMaxValue(memo, row + 1, i);
            memo[row][i] = max + land[row][i];
        }
    }

    public int getMaxValue(int[][] memo, int row, int exceptedIndex) {
        int result = 0;

        for (int i = 0; i < 4; i++) {
            if (i == exceptedIndex)
                continue;

            result = Math.max(result, memo[row][i]);
        }

        return result;
    }
}