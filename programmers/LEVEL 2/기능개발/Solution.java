import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> completeDay = new LinkedList<Integer>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        int funcCount = 0, currentDay = 0;
        int progressLength = progresses.length;

        //기능 개발에 소요되는 일 수를 계산한다.
        for (int i = 0; i < progressLength; i++) {
            int day = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            completeDay.add(day);
        }

        currentDay = completeDay.peek();

        //기능 배포 수를 계산한다.
        while(!completeDay.isEmpty()) {
            if (currentDay >= completeDay.peek()) {
                funcCount++;
                completeDay.poll();
            }
            else {
                resultList.add(funcCount);
                funcCount = 0;
                currentDay = completeDay.peek();
            }
        }
        resultList.add(funcCount);

        int resultLength = resultList.size();
        int[] result = new int[resultLength];

        for (int i = 0; i < resultLength; i++)
            result[i] = resultList.get(i);

        return result;
    }
}
