import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public int[] solution(int[] numbers) {
        int numberLength = numbers.length;
        HashSet<Integer> answerSet = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < numberLength - 1; i++) {
            for (int j = i + 1; j < numberLength; j++) {
                sum = numbers[i] + numbers[j];
                answerSet.add(sum);
            }
        }

        int[] answer = new int[answerSet.size()];
        Iterator<Integer> iter = answerSet.iterator();

        int i = 0;
        while(iter.hasNext()) {
            int value = (int) iter.next();
            answer[i] = value;
            i++;
        }

        return answer;
    }
}