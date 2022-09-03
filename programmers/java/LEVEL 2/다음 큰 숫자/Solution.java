class Solution {
    public int solution(int n) {
        int answer = n;
        String s = Integer.toBinaryString(n);
        int numberOfOne = countOne(s);

        while (numberOfOne != countOne(Integer.toBinaryString(++answer))) {}

        return answer;
    }

    public int countOne(String s) {
        char[] chars = s.toCharArray();
        int result = 0;

        for (char aChar : chars) {
            if (aChar == '1')
                result++;
        }

        return result;
    }
}