import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        int numberOfMaze = maze.length;
        int mazeSize = maze[0].length();
        char[][] charMaze = new char[numberOfMaze][mazeSize];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfMaze; i++) {
            charMaze[i] = maze[i].toCharArray();
        }

        for (int i = 0; i < numberOfMaze; i++) {
            for (int j = 0; j < mazeSize; j++) {
                if (charMaze[i][j] == '.' && !(i == startRow && j == startCol)) {
                    int moveCount = bfs(charMaze, i, j, startRow, startCol, moveRow, moveCol);
                    if (moveCount == -1)
                        return moveCount;
                    else
                        result = Math.max(result, moveCount);
                }
            }
        }

        return result;
    }

    public static int bfs(char[][] charMaze, int destRow, int destCol,
                          int startRow, int startCol, int[] moveRow, int[] moveCol) {
        int mazeRowSize = charMaze.length;
        int mazeColSize = charMaze[0].length;
        int moveSize = moveRow.length;
        boolean[][] visit = new boolean[mazeRowSize][mazeColSize];
        int[][] moveCount = new int[mazeRowSize][mazeColSize];

        visit[startRow][startCol] = true;
        Queue<String> queue = new LinkedList<>();
        queue.add(startRow + " " + startCol);

        while (!queue.isEmpty()) {
            String[] index = queue.poll().split(" ");
            int row = Integer.parseInt(index[0]);
            int col = Integer.parseInt(index[1]);

            for (int i = 0; i < moveSize; i++) {
                int movedRow = row + moveRow[i];
                int movedCol = col + moveCol[i];
                if (movedRow >= 0 && movedRow < mazeRowSize && movedCol >= 0 && movedCol < mazeColSize) {
                    if (!visit[movedRow][movedCol] && charMaze[movedRow][movedCol] == '.') {
                        moveCount[movedRow][movedCol] = moveCount[row][col] + 1;
                        queue.add(movedRow + " " +movedCol);
                        visit[movedRow][movedCol] = true;

                        if (destRow == movedRow && destCol == movedCol)
                            return moveCount[movedRow][movedCol];
                    }
                }
            }
        }

        return -1;
    }
}