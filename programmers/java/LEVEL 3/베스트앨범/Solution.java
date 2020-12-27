import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int numberOfMusic = plays.length;
        HashMap<String, ArrayList<Integer>> eachGenrePlayMap = new HashMap<>(); //<장르, 장르 index list>
        HashMap<String, Integer> eachGenrePlayCountMap = new HashMap<>(); //<장르, 총 재생 횟수>

        //장르 별 index list, 총 재생 횟수 생성
        for (int i = 0; i < numberOfMusic; i++) {
            if (!eachGenrePlayMap.containsKey(genres[i])) {
                setNewGenre(genres[i], eachGenrePlayMap, i);
            }
            else {
                ArrayList<Integer> currentGenrePlayList = eachGenrePlayMap.get(genres[i]);
                currentGenrePlayList.add(i);
            }

            if (!eachGenrePlayCountMap.containsKey(genres[i])) {
                eachGenrePlayCountMap.put(genres[i], plays[i]);
            }
            else {
                int prevPlayCount = eachGenrePlayCountMap.get(genres[i]);
                eachGenrePlayCountMap.put(genres[i], prevPlayCount + plays[i]);
            }
        }

        //총 재생 횟수가 많은 순으로 정렬
        List<Map.Entry<String, Integer>> eachGenrePlayCountList = descendingSortByPlayCount(eachGenrePlayCountMap);
        int eachGenrePlayCountListSize = eachGenrePlayCountList.size();

        //장르가 하나면 바로 index 저장, 아닐 시 장르 내에서 재생 횟수가 가장 많은 두 가지 저장.
        for (int i = 0; i < eachGenrePlayCountListSize; i++) {
            String currentGenre = eachGenrePlayCountList.get(i).getKey();
            ArrayList<Integer> currentGenrePlayList = eachGenrePlayMap.get(currentGenre);

            int currentGenrePlayListSize = currentGenrePlayList.size();
            int searchRange = currentGenrePlayListSize == 1 ? 1 : 2;

            if (searchRange == 1)
                answerList.add(currentGenrePlayList.get(0));
            else
                setTopTwoPlayList(answerList, currentGenrePlayList, plays);
        }

        //배열로 변환
        int answerListSize = answerList.size();
        int[] answer = new int[answerListSize];

        for (int i = 0; i < answerListSize; i++)
            answer[i] = answerList.get(i);

        return answer;
    }

    private void setTopTwoPlayList(ArrayList<Integer> answerList, ArrayList<Integer> currentGenrePlayList, int[] plays) {
        int currentGenrePlayListSize = currentGenrePlayList.size();
        int maxPlayCount = Integer.MIN_VALUE;
        int maxPlayCountIndex = -1;

        for (int i = 0; i < 2; i++) {
            for (int j = i; j < currentGenrePlayListSize; j++) {
                int currentPlayCountIndex = currentGenrePlayList.get(j);

                if (maxPlayCount < plays[currentPlayCountIndex]) {
                    maxPlayCount = plays[currentPlayCountIndex];
                    maxPlayCountIndex = j;
                }
            }
            Collections.swap(currentGenrePlayList, i, maxPlayCountIndex);
            answerList.add(currentGenrePlayList.get(i));
            maxPlayCount = Integer.MIN_VALUE;
        }
    }

    private List<Map.Entry<String, Integer>> descendingSortByPlayCount(HashMap<String, Integer> eachGenrePlayCountMap) {
        List<Map.Entry<String, Integer>> eachGenrePlayCountList = new LinkedList<>(eachGenrePlayCountMap.entrySet());
        Collections.sort(eachGenrePlayCountList, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        return eachGenrePlayCountList;
    }

    private void setNewGenre(String genre, HashMap<String, ArrayList<Integer>> eachGenrePlayMap, int i) {
        ArrayList<Integer> newGenreList = new ArrayList<>();
        newGenreList.add(i);
        eachGenrePlayMap.put(genre, newGenreList);
    }
}