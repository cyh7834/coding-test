class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] numpadPos = {
                {3,1},
                {0,0},
                {0,1},
                {0,2},
                {1,0},
                {1,1},
                {1,2},
                {2,0},
                {2,1},
                {2,2}
        };
        int[] left_thumb = new int[]{3,0};
        int[] right_thumb = new int[]{3,2};

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                setThumbLocation(left_thumb, numpadPos[number][0], numpadPos[number][1]);
            }
            else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                setThumbLocation(right_thumb, numpadPos[number][0], numpadPos[number][1]);
            }
            else {
                int leftDistance = getDistance(left_thumb, numpadPos[number][0], numpadPos[number][1]);
                int rightDistance = getDistance(right_thumb, numpadPos[number][0], numpadPos[number][1]);
                String thumb = choiceThumb(leftDistance, rightDistance, hand);

                if (thumb.equals("L")) {
                    answer.append("L");
                    setThumbLocation(left_thumb, numpadPos[number][0], numpadPos[number][1]);
                }
                else {
                    answer.append("R");
                    setThumbLocation(right_thumb, numpadPos[number][0], numpadPos[number][1]);
                }
            }
        }

        return answer.toString();
    }
    private int getDistance(int[] thumb, int x, int y) {
        return Math.abs(thumb[0] - x) + Math.abs(thumb[1] - y);
    }

    private String choiceThumb(int leftDistance, int rightDistance, String hand) {
        if (leftDistance < rightDistance)
            return "L";
        else if (leftDistance > rightDistance)
            return "R";
        else {
            if (hand.equals("left"))
                return "L";
            else
                return "R";
        }
    }

    private void setThumbLocation(int[] thumb, int x, int y) {
        thumb[0] = x;
        thumb[1] = y;
    }
}