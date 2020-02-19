import java.util.*;

public class Solution {
    public int solution(String[] first, String[] second) {
        Map<String, Integer> interest = new HashMap<>();
        int firstLength = first.length;
        int answer = 0;
        for (int i = 0; i < firstLength; i++) {
            if (interest.containsKey(first[i])) {
                interest.replace(first[i], interest.get(first[i]) + 1);
            }
            else
                interest.put(first[i], 1);

            if (interest.containsKey(second[i])) {
                interest.replace(second[i], interest.get(second[i]) + 1);
            }
            else
                interest.put(second[i], 1);
        }

        for (String key : interest.keySet())
            answer = Math.max(answer, interest.get(key));

        return answer;
    }
}
