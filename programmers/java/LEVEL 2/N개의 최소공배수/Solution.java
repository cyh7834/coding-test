import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        int numberCount = arr.length;

        for (int i = 1; i < numberCount; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        return a;
    }
}