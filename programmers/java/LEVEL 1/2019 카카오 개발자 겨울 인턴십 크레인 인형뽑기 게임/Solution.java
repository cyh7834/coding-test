import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> selectedDoll = new Stack<>();
        List<Stack<Integer>> stackBoard = getStackBoard(board);

        for (int move : moves) {
            Stack<Integer> dolls = stackBoard.get(move - 1);

            if (dolls.empty())
                continue;

            int doll = dolls.pop();

            if (selectedDoll.empty()) {
                selectedDoll.push(doll);
                continue;
            }

            int peekDoll = selectedDoll.peek();

            if (doll == peekDoll) {
                selectedDoll.pop();
                answer += 2;
            }
            else {
                selectedDoll.push(doll);
            }
        }

        return answer;
    }

    private List<Stack<Integer>> getStackBoard(int[][] board) {
        int boardSize = board.length;
        List<Stack<Integer>> stackBoard = new ArrayList<>();

        for (int i = 0; i < boardSize; i++) {
            Stack<Integer> dolls = new Stack<>();

            for (int j = boardSize - 1; j >= 0; j--) {
                if (board[j][i] == 0)
                    continue;

                dolls.push(board[j][i]);
            }

            stackBoard.add(dolls);
        }

        return stackBoard;
    }
}