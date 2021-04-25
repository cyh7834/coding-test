public static int solution(String s)
    {
        int searchLength = s.length();
        char[] chars = s.toCharArray();

        for (int i = searchLength - 1; i >= 0; i--) {
            for (int j = 0; j < searchLength - i; j++) {
                int index = 0;
                boolean isPalindrome = true;

                for (int k = 0; k < (i / 2) + 1; k++) {
                    if (chars[j + k] != chars[j + i - index]) {
                        isPalindrome = false;
                        break;
                    }
                    index++;
                }
                if (isPalindrome)
                    return i + 1;
            }
        }
        return 0;
    }