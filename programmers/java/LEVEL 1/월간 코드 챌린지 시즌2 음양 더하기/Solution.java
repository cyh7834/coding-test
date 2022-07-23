public class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int absoluteLength = absolutes.length;

        for (int i = 0; i < absoluteLength; i++) {
            answer += signs[i] ? absolutes[i] : absolutes[i] * -1;
        }
        return answer;
    }
}
