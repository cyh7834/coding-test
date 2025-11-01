class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            int count = 0;
            boolean found = false;
            String lastUsedWord = "";

            for (int i = 0; i < 4; i++) {
                while (b.indexOf(word[i]) == 0 && !lastUsedWord.equals(word[i])) {
                    b = b.substring(word[i].length());
                    lastUsedWord = word[i];
                    i = 0;
                    count = 0;

                    if (b.equals("")) {
                        answer++;
                        count = 0;
                        found = true;

                        break;
                    }
                }

                if (found || count == 4)
                    break;
                else if (i == 3)
                    i = -1;

                count++;
            }
        }

        return answer;
}