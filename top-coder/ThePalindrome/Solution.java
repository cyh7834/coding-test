public class Solution {
    public int solution(String s) {
        char[] sArray = s.toCharArray();
        int sArrayLength = sArray.length;
        int answer = sArrayLength;

        // 문자열 내에서 회문을 찾아서 결과 값을 계산하여 전달한다.
        for (int i = 0; i < sArrayLength; i++) {
            if (sArray[i] == sArray[sArrayLength - 1]) {
                int startIndex = i;
                int endIndex = sArrayLength - 1;
                boolean isPalindrome = false;

                while((startIndex < endIndex) && (startIndex != endIndex)) {
                    if (sArray[startIndex] != sArray[endIndex]) {
                        isPalindrome = false;
                        break;
                    }

                    isPalindrome = true;
                    startIndex++;
                    endIndex--;
                }

                // 문자열 내에 회문이 존재할 때
                if (isPalindrome) {
                    int palindromeLength = sArrayLength - i;

                    // 문자열 전체가 회문이라면 더이상 추가해야할 문자가 없기 때문에 길이 자체를 전달한다.
                    if (palindromeLength == answer)
                        return answer;

                    // 그렇지 않을때엔 회문을 완성했을 때 총 길이를 전달한다.
                    else
                        return answer + (answer - palindromeLength);
                }
            }
        }

        // 문자열 내에 회문이 존재하지 않을 때엔 맨 끝의 문자를 기준으로 회문을 만들었을 때 길이를 전달한다.
        return (answer * 2) - 1;
    }
}
