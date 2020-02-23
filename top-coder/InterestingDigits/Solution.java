import java.util.*;

public class Solution {
    public int[] solution(int base) {
        List<Integer> digit = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int[] answerArray = null;

        // 2부터 999까지의 값을 base 진수로 변환하여 모든 자리수의 값을 더한 결과를 result arraylist에 저장한다.
        for (int i = 2; i < 999; i++) {
            if (i < base)
                result.add(i);
            else {
                int value = i;

                //base 진수로 변환한다.
                while (true) {
                    digit.add(value % base);
                    value = value / base;

                    if (value <= base) {
                        digit.add(value);
                        break;
                    }
                }

                int sum = 0;
                for (int digitValue : digit)
                    sum += digitValue;

                result.add(sum);
                digit = new ArrayList<>();
            }
        }

        boolean isCorrect = true;
        int resultLength = result.size();

        //result arraylist에서 10진수의 배수가 되는 값을 찾는다.
        for (int i = 2; i < base; i++) {
            for (int j = i; j < resultLength; j = j + i) {
                if ((result.get(j - 2) % i) != 0) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect)
                answer.add(i);
            isCorrect = true;
        }
        int answerSize = answer.size();

        answerArray = new int[answerSize];

        for (int i = 0; i < answerSize; i++)
            answerArray[i] = answer.get(i);

        return answerArray;
    }
}
