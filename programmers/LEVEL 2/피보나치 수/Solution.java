import java.util.HashMap;

public class Solution {
    public int solution(int n) {
        int first = 0;
        int second = 1;
        int answer = 1;

        for (int i = 0; i < n - 1; i++) {
            answer = (first + second) % 1234567;
            first = second;
            second = answer;
        }

        return answer;
    }
}
