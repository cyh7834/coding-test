class Solution {
    public String solution(int[] food) {
        String answer = "0";
        int length = food.length;
        StringBuilder player1 = new StringBuilder();
        StringBuilder player2 = new StringBuilder();

        for (int i = 1; i < length; i++) {
            if (food[i] == 1)
                continue;

            int eachFood = food[i] % 2 == 0 ? food[i] / 2 : (food[i] - 1) / 2;

            for (int j = 0; j < eachFood; j++) {
                player1.append(i);
                player2.append(i);
            }
        }

        return player1 + answer + player2.reverse();
    }
}