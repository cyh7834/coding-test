import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int languageLength = languages.length;
        int maxScore = 0;
        HashMap<String, HashMap<String, Integer>> tableMap = new HashMap<>();

        setTableMap(table, tableMap);

        for (Map.Entry<String, HashMap<String, Integer>> entry : tableMap.entrySet()) {
            HashMap<String, Integer> languageScore = entry.getValue();
            int totalScore = 0;
            String currentKey = entry.getKey();

            for (int i = 0; i < languageLength; i++) {
                if (languageScore.containsKey(languages[i]))
                    totalScore += languageScore.get(languages[i]) * preference[i];
            }

            if (totalScore > maxScore) {
                answer = currentKey;
                maxScore = totalScore;
            }
            else if (totalScore == maxScore) {
                int compareResult = currentKey.compareTo(answer);

                if (compareResult < 0)
                    answer = currentKey;
            }
        }

        return answer;
    }

    private void setTableMap(String[] table, HashMap<String, HashMap<String, Integer>> tableMap) {
        for (String data : table) {
            String[] parsedData = data.split(" ");
            int parsedDataLength = parsedData.length;
            HashMap<String, Integer> languageScore = new HashMap<>();
            int score = parsedDataLength - 1;

            for (int i = 1; i < parsedDataLength; i++)
                languageScore.put(parsedData[i], score--);

            tableMap.put(parsedData[0], languageScore);
        }
    }
}
