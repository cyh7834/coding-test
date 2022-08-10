import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        List<Integer> carpetList = new ArrayList<>();

        for (int i = 1; i <= total; i++) {
            if (total % i == 0) {
                carpetList.add(i);

                if (i * i == total) 
                    carpetList.add(i);
            }
        }

        int carpetSize = carpetList.size();
        int numberOfUsableCarpet = carpetList.size() / 2;

        for (int i = 0; i < numberOfUsableCarpet; i++) {
            int row = carpetList.get(i);
            int col = carpetList.get(carpetSize - i - 1);

            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;

                break;
            }
        }

        return answer;
    }
}