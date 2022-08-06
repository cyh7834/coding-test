import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String s) {
        String[] splitString = s.split(" ");
        List<Integer> splitList = new ArrayList<>();

        for (String value : splitString) {
            splitList.add(Integer.parseInt(value));
        }

        Collections.sort(splitList);

        return splitList.get(0) + " " + splitList.get(splitList.size() - 1);
    }
}