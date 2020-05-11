public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1RowLength = arr1.length;
        int arr1ColLength = arr1[0].length;
        int arr2ColLength = arr2[0].length;
        int mul = 0;
        int[][] answer = new int[arr1RowLength][arr2ColLength];
        int i = 0, j = 0, k = 0;

        while(i < arr1RowLength) {
            mul += arr1[i][j] * arr2[j][k];

            if (j + 1 == arr1ColLength && k + 1 == arr2ColLength) {
                answer[i][k] = mul;
                i++;
                j = 0;
                k = 0;
                mul = 0;
            }
            else if (j + 1 == arr1ColLength) {
                answer[i][k] = mul;
                k++;
                j = 0;
                mul = 0;
            }
            else
                j++;
        }

        return answer;
    }
}
