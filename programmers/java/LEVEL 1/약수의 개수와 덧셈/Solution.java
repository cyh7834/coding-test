class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int count = 1;

        for (int i = left; i <= right; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0)
                    count++;
            }

            if (count % 2 == 0)
                answer += i;
            else
                answer -= i;

            count = 1;
        }

        return answer;
    }
}