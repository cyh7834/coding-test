import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        List<String> recordList = new ArrayList<String>();
        Map<String, String> nickNameMap = new HashMap<String, String>();

        // id : nickname 쌍의 HashMap 생성.
        for (String s : record) {
            String[] parsedRecord = s.split(" ");
            if (parsedRecord[0].equalsIgnoreCase("Enter") ||
                    parsedRecord[0].equalsIgnoreCase("Change")) {
                nickNameMap.put(parsedRecord[1], parsedRecord[2]);
            }
        }

        // 각 record 별로 nickname을 할당하여 ArrayList로 저장
        for (String s : record) {
            String[] parsedRecord = s.split(" ");
            if (parsedRecord[0].equalsIgnoreCase("Enter")) {
                StringBuilder recordBuilder = new StringBuilder(nickNameMap.get(parsedRecord[1]));
                recordBuilder.append("님이 들어왔습니다.");
                recordList.add(recordBuilder.toString());
            }
            else if (parsedRecord[0].equalsIgnoreCase("Leave")) {
                StringBuilder recordBuilder = new StringBuilder(nickNameMap.get(parsedRecord[1]));
                recordBuilder.append("님이 나갔습니다.");
                recordList.add(recordBuilder.toString());
            }

        }
        int recordListSize = recordList.size();

        // record ArrayList를 배열로 저장.
        answer = new String[recordListSize];
        for (int i = 0; i < recordListSize; i++)
            answer[i] = recordList.get(i);

        return answer;
    }
}
