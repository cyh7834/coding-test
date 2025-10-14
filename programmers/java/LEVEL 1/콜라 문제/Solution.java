class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (a <= n) {
            int newCola = (n / a) * b;
            int remainCola = n % a;

            answer += newCola;
            n = newCola + remainCola;
        }

        return answer;
    }
}