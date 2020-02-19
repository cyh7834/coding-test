import java.util.*;

public class Solution {
    public int[] solution(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        int fromIdLength = fromId.length;

        for (int i=0; i < fromIdLength; i++) {
            int remainder = capacities[toId[i]] - bottles[toId[i]];

            if (bottles[fromId[i]] <= remainder) {
                bottles[toId[i]] += bottles[fromId[i]];
                bottles[fromId[i]] = 0;
            }
            else {
                bottles[toId[i]] += remainder;
                bottles[fromId[i]] -= remainder;
            }
        }

        return bottles;
    }
}
