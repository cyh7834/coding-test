import java.util.HashSet;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int wordLength = words.length;
        HashSet<String> wordHash = new HashSet<>();
        wordHash.add(words[0]);

        for (int i = 1; i < wordLength; i++) {
            if (wordHash.contains(words[i]) ||
                    words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;

                return answer;
            }
            wordHash.add(words[i]);
        }

        return answer;
    }
}
