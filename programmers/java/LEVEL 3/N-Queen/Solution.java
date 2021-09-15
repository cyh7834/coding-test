class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            boolean[][] board = new boolean[n][n];
            answer += dfs(board, 0, i, 0);
        }
        return answer;
    }

    private int dfs(boolean[][] board, int row, int col, int result) {
        int boardSize = board.length;

        board[row][col] = true;

        if (row + 1 == boardSize) {
            result++;
            board[row][col] = false;

            return result;
        }

        for (int i = 0; i < boardSize; i++) {
            if (check(board, row + 1, i)) {
                result = dfs(board, row + 1, i, result);
            }
        }

        board[row][col] = false;

        return result;
    }

    private boolean check(boolean[][] board, int row, int col) {
        int boardSizeIndex = board.length - 1;
        int startRow = row;
        int startCol = col;

        while (startRow > 0 && startCol > 0) {
            startRow--;
            startCol--;

            if (board[startRow][startCol])
                return false;
        }

        startRow = row;
        startCol = col;

        while (startRow < boardSizeIndex && startCol < boardSizeIndex) {
            startRow++;
            startCol++;

            if (board[startRow][startCol])
                return false;
        }

        startRow = row;
        startCol = col;

        while (startRow > 0 && startCol < boardSizeIndex) {
            startRow--;
            startCol++;

            if (board[startRow][startCol])
                return false;
        }

        startRow = row;
        startCol = col;

        while (startRow < boardSizeIndex && startCol > 0) {
            startRow++;
            startCol--;

            if (board[startRow][startCol])
                return false;
        }

        for (int i = 0; i < boardSizeIndex + 1; i++) {
            if (board[i][col])
                return false;
        }

        return true;
    }
}