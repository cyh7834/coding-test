public class Solution {
    public int solution(String answer) {
        if (answer.equals("YYYY"))
            return 1;
        else if (answer.equals("NNNN"))
            return 16;

        int result = 0;
        char[] charAnswer = answer.toCharArray();
        HashSet<Integer> numberSet = new HashSet<>();

        int[][] card = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8},
                {1, 2, 3, 4, 9, 10, 11, 12},
                {1, 2, 5, 6, 9, 10, 13, 14},
                {1, 3, 5, 7, 9, 11, 13, 15}};

        if (charAnswer[0] == 'Y') {
            for (int number : card[0])
                numberSet.add(number);
        }
        else {
            for (int i = 9; i < 17; i++)
                numberSet.add(i);
        }

        for (int i = 1; i < 4; i++) {
            if (charAnswer[i] == 'Y') {
                Iterator<Integer> iterator = numberSet.iterator();
                while (iterator.hasNext()) {
                    Integer number = iterator.next();
                    if (!existNumber(number, card[i])) {
                        iterator.remove();
                    }
                }
            }
            else {
                for (int number : card[i])
                    numberSet.remove(number);
            }
        }

        for (int number : numberSet)
            result = number;

        return result;
    }

    private boolean existNumber(int number, int[] card) {
        for (int cardNumber : card) {
            if (cardNumber == number)
                return true;
        }

        return false;
    }
}