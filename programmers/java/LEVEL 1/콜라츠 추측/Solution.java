class Solution {
    public int solution(int num) {
        if (num == 1)
            return 0;

        long longNum = num;

        for (int i = 1; i < 501; i++) {
            longNum = calculate(longNum);
            System.out.println(i + " " + longNum);
            if (longNum == 1)
                return i;
        }

        return -1;
    }

    private long calculate(long num) {
        return num % 2 == 0 ? num / 2 : (num * 3) + 1;
    }
}