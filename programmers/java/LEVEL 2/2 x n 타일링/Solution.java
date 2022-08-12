class Solution {
    public int solution(int n) {
        int a = 1;
        int b = 2;
        int answer = 0;

        for (int i = 2; i < n; i++) {
            answer = a + b;
            a = b;
            b = answer % 1000000007;
        }

        return answer % 1000000007;
    }
}