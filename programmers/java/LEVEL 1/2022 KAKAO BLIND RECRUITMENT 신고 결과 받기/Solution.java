import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        int reportCount = report.length;

        for (int i = 0; i < reportCount; i++) {
            String[] splitReport = report[i].split(" ");

            if (!reportMap.containsKey(splitReport[1])) {
                HashSet<String> reporterSet = new HashSet<>();
                reporterSet.add(splitReport[0]);

                reportMap.put(splitReport[1], reporterSet);
            }
            else {
                reportMap.get(splitReport[1]).add(splitReport[0]);
            }
        }

        int idCount = id_list.length;
        int[] answer = new int[idCount];

        HashMap<String, Integer> idMap = new HashMap<>();
        for (Map.Entry<String, HashSet<String>> reportEntry : reportMap.entrySet()) {
            HashSet<String> reporterSet = reportEntry.getValue();

            if (reporterSet.size() >= k) {
                for (String reporter : reporterSet) {
                    if (!idMap.containsKey(reporter)) {
                        idMap.put(reporter, 1);
                    }
                    else {
                        idMap.replace(reporter, idMap.get(reporter) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < idCount; i++) {
            if (idMap.containsKey(id_list[i])) {
                answer[i] = idMap.get(id_list[i]);
            }
        }
        
        return answer;
    }
}