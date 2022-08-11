import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        char[] numberChars = numbers.toCharArray();
        int numberLength = numbers.length();
        HashSet<String> numberSet = new HashSet<>();

        for (int i = 1; i <= numberLength; i++) {
            dfs(numberChars, i, new StringBuilder(), new boolean[numberLength], numberSet);
        }

        for (String stringNumber : numberSet) {
            int number = Integer.parseInt(stringNumber);

            if (isPrime(number))
                answer++;
        }

        return answer;
    }

    public void dfs(char[] numberChars, int digit, StringBuilder number, boolean[] visit, HashSet<String> numberSet) {
        int numberLength = numberChars.length;
        int calculatedNumberLength = number.length();

        if (digit == calculatedNumberLength) {
            numberSet.add(number.toString());

            return;
        }

        for (int i = 0; i < numberLength; i++) {
            if (calculatedNumberLength == 0 && numberChars[i] == '0')
                continue;

            if (!visit[i]) {
                number.append(numberChars[i]);
                visit[i] = true;
                dfs(numberChars, digit, number, visit, numberSet);
                number.deleteCharAt(number.length() - 1);
                visit[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}