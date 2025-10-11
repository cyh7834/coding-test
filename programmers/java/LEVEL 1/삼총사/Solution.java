class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int numberLength = number.length;

        for (int i = 0; i < numberLength - 2; i++) {
            for (int j = i + 1; j <numberLength - 1; j++) {
                for (int k = j + 1; k < numberLength; k++) {
                    if (number[i] + number[j] + number[k] == 0)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}