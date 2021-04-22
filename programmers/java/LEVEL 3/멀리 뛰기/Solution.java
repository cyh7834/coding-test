import java.util.*;

public class Solution {
    public long solution(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);

        for (int i = 2; i <= n; i++) {
            int currentValue = result.get(i - 2) + result.get(i - 1) % 1234567;
            result.add(currentValue);
        }

        return result.get(n) % 1234567;
    }
}