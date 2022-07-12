public class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correctCount = 0;
        int zeroCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }

            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    correctCount++;
                }
            }
        }
        answer[0] = getRank(correctCount +  zeroCount);
        answer[1] = getRank(correctCount);

        return answer;
    }

    private int getRank(int count) {
        if (count == 6)
            return 1;
        else if (count == 5)
            return 2;
        else if (count == 4)
            return 3;
        else if (count == 3)
            return 4;
        else if (count == 2)
            return 5;
        else
            return 6;
    }
}
