import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        int numberOfScore = score.length;
        List<Integer> list = new ArrayList();
        List<Integer> answer = new ArrayList();

        for (int i = 0; i < k; i++) {
            if (i == numberOfScore) {
                break;
            }
            
            list.add(score[i]);
            list.sort(Comparator.comparingInt(a -> a));
            answer.add(list.get(0));
        }

        for (int i = k; i < numberOfScore; i++) {
            if (list.get(0) <= score[i]) {
                list.remove(0);
                list.add(0, score[i]);
                list.sort(Comparator.comparingInt(a -> a));
            }

            answer.add(list.get(0));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}