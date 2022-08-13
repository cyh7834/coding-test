class Solution {
    class Result {
        boolean find;
        int count;
    }

    public int solution(String word) {
        Result result = new Result();
        dfs(new StringBuilder(), word, result);

        return result.count;
    }

    public void dfs(StringBuilder currentWord, String word, Result result) {
        if (result.find)
            return;

        String currentString = currentWord.toString();

        if (currentString.equals(word)) {
            result.find = true;

            return;
        }
        else if (currentString.length() == 5)
            return;

        char[] alpha = new char[]{'A', 'E', 'I', 'O', 'U'};

        for (char c : alpha) {
            currentWord.append(c);
            result.count += 1;

            dfs(currentWord, word, result);

            if (result.find)
                break;

            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }
}