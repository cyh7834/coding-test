class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0;
        int card2Index = 0;
        int numberOfCard1 = cards1.length;
        int numberOfCard2 = cards2.length;

        for (String currentWord : goal) {
            if (card1Index < numberOfCard1 && cards1[card1Index].equals(currentWord))
                card1Index++;
            else if (card2Index < numberOfCard2 && cards2[card2Index].equals(currentWord))
                card2Index++;
            else
                return "No";
        }

        return "Yes";
    }
}