import java.util.Arrays;

public class Solution {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int arrayLength = B.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < arrayLength; i++)
            answer += A[i] * B[arrayLength - 1 - i];

        return answer;
    }
}
