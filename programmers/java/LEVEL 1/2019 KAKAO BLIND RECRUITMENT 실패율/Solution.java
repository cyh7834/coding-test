import java.util.*;

class Solution {
        public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> rankMap = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            int notCompletedPlayer = 0;
            int totalPlayer = 0;

            for (int stage : stages) {
                if (stage == i) {
                    notCompletedPlayer++;
                    totalPlayer++;
                }
                else if (stage > i) {
                    totalPlayer++;
                }
            }

            rankMap.put(i, totalPlayer > 0 ? (double) notCompletedPlayer / totalPlayer : 0.0);
        }

        List<Integer> rankList = sortRankByRate(rankMap);

        for (int i = 0; i < N; i++)
            answer[i] = rankList.get(i);

        return answer;
    }
    
    private List<Integer> sortRankByRate(HashMap<Integer, Double> rankMap) {
        List<Integer> rankList = new ArrayList<>(rankMap.keySet());

        rankList.sort((key1, key2) -> {
            Double rate1 = rankMap.get(key1);
            Double rate2 = rankMap.get(key2);

            if (rate1 > rate2)
                return -1;
            else if (rate1 < rate2)
                return 1;
            else
                return key1 - key2;
        });

        return rankList;
    }
}