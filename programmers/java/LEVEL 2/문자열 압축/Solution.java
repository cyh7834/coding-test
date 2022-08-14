class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int stringLength = s.length();
        String startString, targetString;

        for (int i = 1; i <= stringLength / 2; i++) {
            StringBuilder resultString = new StringBuilder();
            int endIndex = i;
            int count = 1;
            boolean isDone = false;
            startString = s.substring(0, endIndex);

            while (!isDone) {
                if (endIndex + i >= stringLength) {
                    isDone = true;
                    targetString = s.substring(endIndex, stringLength);
                }
                else {
                    targetString = s.substring(endIndex, endIndex + i);
                }

                if (startString.equals(targetString)) {
                    count++;
                }
                else {
                    if (count > 1) {
                        resultString.append(count);
                    }

                    resultString.append(startString);
                    startString = targetString;
                    count = 1;
                }

                endIndex += i;
            }

            if (count > 1) {
                resultString.append(count);
            }

            resultString.append(startString);
            answer = Math.min(answer, resultString.length());
        }

        return answer;
    }
}