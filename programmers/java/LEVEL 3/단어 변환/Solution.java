import java.util.*;

public static int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        int numberOfWord = words.length;
        int wordLength = words[0].length();
        boolean[][] graph = new boolean[numberOfWord][numberOfWord];
        int targetIndex = -1;
        targetIndex = getTargetIndex(target, words, numberOfWord, targetIndex);

        if (targetIndex == -1)
            return 0;

        setGraph(graph, words);

        char[] beginWord = begin.toCharArray();

        for (int i = 0; i < numberOfWord; i++) {
            char[] currentWord = words[i].toCharArray();
            int wrongCount = getWrongCount(wordLength, beginWord, currentWord);

            if (wrongCount == 1 && words[i].equals(target))
                return 1;

            int[] moveCount = new int[numberOfWord];

            if (wrongCount == 0 || wrongCount == 1) {
                for (int j = 0; j < numberOfWord; j++) {
                    moveCount[j] = i == j ? wrongCount : -1;
                }
                bfs(graph, i, targetIndex, moveCount);
                answer = Integer.min(answer, moveCount[targetIndex]);
            }
        }
        if (answer == Integer.MAX_VALUE)
            return 0;

        return answer;
    }

    private static int getTargetIndex(String target, String[] words, int numberOfWord, int targetIndex) {
        for (int i = 0; i < numberOfWord; i++) {
            if (target.equals(words[i])) {
                targetIndex = i;
                break;
            }
        }
        return targetIndex;
    }

    private static void bfs(boolean[][] graph, int startIndex, int targetIndex, int[] moveCount) {
        int graphLength = graph.length;
        boolean[] visit = new boolean[graphLength];
        visit[startIndex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);

        while(!queue.isEmpty()) {
            int currentIndex = queue.poll();

            for (int i = 0; i < graphLength; i++) {
                if (!visit[i] && graph[currentIndex][i]) {
                    queue.add(i);
                    moveCount[i] = moveCount[currentIndex] + 1;
                    visit[i] = true;

                    if (i == targetIndex)
                        return;
                }
            }
        }
    }

    private static void setGraph(boolean[][] graph, String[] words) {
        int numberOfWord = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i < numberOfWord; i++) {
            char[] startWord = words[i].toCharArray();

            for (int j = 0; j < numberOfWord; j++) {
                if (i == j) {
                    graph[i][j] = true;
                    continue;
                }

                char[] endWord = words[j].toCharArray();
                int wrongCount = getWrongCount(wordLength, startWord, endWord);

                graph[i][j] = wrongCount == 1;
            }
        }
    }

    private static int getWrongCount(int wordLength, char[] startWord, char[] endWord) {
        int wrongCount = 0;

        if (Arrays.toString(startWord).equals(Arrays.toString(endWord)))
            return wrongCount;

        for (int k = 0; k < wordLength; k++) {
            if (startWord[k] != endWord[k]) {
                wrongCount++;

                if (wrongCount > 1)
                    break;
            }
        }
        return wrongCount;
    }
}
