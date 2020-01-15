import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantHashMap = new HashMap<String, Integer>();

        //참가자의 이름과 동명이인을 계산하여 HashMap에 저장한다.
        for (String participantData : participant) {
            if (participantHashMap.get(participantData) == null)
                participantHashMap.put(participantData, 1);

            else {
                int playerCount = participantHashMap.get(participantData);
                participantHashMap.replace(participantData, playerCount + 1);
            }
        }

        //완주에 성공한 선수의 이름을 HashMap에서 찾아 제거한다.
        for (String completionData : completion) {
            int playerCount = participantHashMap.get(completionData);

            if (playerCount > 1)
                participantHashMap.replace(completionData, playerCount - 1);

            else if (playerCount == 1)
                participantHashMap.remove(completionData);
        }

        //남은 선수의 이름을 전달한다.
        Iterator<String> resultPlayer = participantHashMap.keySet().iterator();
        String result = resultPlayer.next();

        return result;
    }
}
