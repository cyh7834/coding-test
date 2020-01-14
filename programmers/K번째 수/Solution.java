import java.util.*;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<Integer>();

        //각 command의 값을 사용하여 배열을 계산한다.
        for (int[] command : commands) {
            int[] calculatedValue = new int[(command[1] - command[0]) + 1];
            int index = 0;

            for (int i = command[0] - 1; i < command[1]; i++)
                calculatedValue[index++] = array[i];

            Arrays.sort(calculatedValue);
            result.add(calculatedValue[command[2] - 1]);
        }

        //결과 값을 배열로 변환하여 전달한다. 자바 1.8의 stream().mapToInt.toArray 방식보다 약 4ms 더 빠르다.
        int resultSize = result.size();
        int[] answer = new int[resultSize];

        for (int i = 0; i < resultSize; i++)
            answer[i] = result.get(i);

        return answer;
    }
}
