public class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int numberLength = a.length;

        for (int i = 0; i < numberLength; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}
