class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] procession = new int[rows][columns];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                procession[i][j] = value++;
            }
        }

        int answerIndex = 0;

        for (int[] query : queries) {
            int currentRow = query[0];
            int currentCol = query[1];
            int prevValue = procession[currentRow - 1][currentCol - 1];
            int minValue = prevValue;

            while (currentCol < query[3]) {
                ++currentCol;
                prevValue = switchValue(currentCol, prevValue, procession[currentRow - 1]);
                minValue = Math.min(minValue, prevValue);
            }

            while (currentRow < query[2]) {
                ++currentRow;
                prevValue = switchValue(currentCol, prevValue, procession[currentRow - 1]);
                minValue = Math.min(minValue, prevValue);
            }

            while (currentCol > query[1]) {
                --currentCol;
                prevValue = switchValue(currentCol, prevValue, procession[currentRow - 1]);
                minValue = Math.min(minValue, prevValue);
            }

            while (currentRow > query[0]) {
                --currentRow;
                prevValue = switchValue(currentCol, prevValue, procession[currentRow - 1]);
                minValue = Math.min(minValue, prevValue);
            }

            answer[answerIndex++] = minValue;
        }

        return answer;
    }

    private int switchValue(int currentCol, int prevValue, int[] query) {
        int currentValue = query[currentCol - 1];
        query[currentCol - 1] = prevValue;

        return currentValue;
    }
}