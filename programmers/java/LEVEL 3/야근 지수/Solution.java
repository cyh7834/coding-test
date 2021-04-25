class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int workLength = works.length;
        int maxWork = 0;
        for (int i = 0; i < workLength; i++) {
            if (works[i] > maxWork) {
                maxWork = works[i];
            }
        }

        while (n != 0) {
            for (int i = 0; i < workLength; i++) {
                if (works[i] >= maxWork) {
                    works[i] -= 1;
                    n--;

                    if (n == 0)
                        break;
                }
            }
            if (n != 0)
                maxWork--;

            if (maxWork == 0)
                break;
        }

        for (int work : works) {
            answer += Math.pow(work, 2);
        }
        return answer;
    }
}