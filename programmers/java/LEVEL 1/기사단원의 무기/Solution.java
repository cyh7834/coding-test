class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int numberOfDivisor = 0;
            int sqrt = (int) Math.sqrt(i);

            for (int j = 1; j <= sqrt; j++) {
                if (j * j == i)
                    numberOfDivisor++;
                else if (i % j == 0)
                    numberOfDivisor += 2;
            }

            if (numberOfDivisor <= limit)
                answer += numberOfDivisor;
            else
                answer += power;
        }

        return answer;
    }
}