class Solution {
    public int[] solution(String s) {
        int convertCount = 0;
        int zeroCount = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while(!s.equals("1")) {
            convertCount++;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == '0') {
                    zeroCount++;
                    continue;
                }

                stringBuilder.append(aChar);
            }

            int length = stringBuilder.length();
            s = Integer.toBinaryString(length);
            stringBuilder = new StringBuilder();
        }

        return new int[]{convertCount, zeroCount};
    }
}