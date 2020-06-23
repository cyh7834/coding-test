import java.util.*;

public class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        char[] char1 = str1.toLowerCase().toCharArray();
        char[] char2 = str2.toLowerCase().toCharArray();
        ArrayList<String> arrList1 = new ArrayList<>();
        ArrayList<String> arrList2 = new ArrayList<>();
        int char1Length = char1.length;
        int char2Length = char2.length;
        int intersection = 0;
        int union = 0;

        // 알파벳 소문자 일때 집합을 만든다.
        for (int i = 0; i < char1Length - 1; i++) {
            if ((char1[i] >= 65 && char1[i] <= 122) && (char1[i + 1] >= 65 && char1[i + 1] <= 122))
                arrList1.add(char1[i] + "" + char1[i + 1]);
        }

        for (int i = 0; i < char2Length - 1; i++) {
            if ((char2[i] >= 65 && char2[i] <= 122) && (char2[i + 1] >= 65 && char2[i + 1] <= 122))
                arrList2.add(char2[i] + "" + char2[i + 1]);
        }

        if (arrList2.size() == 0)
            return 65536;

        // 교집합의 원소 개수를 구하고 합집합 게산을 위해 원소를 제거.
        for (String arr : arrList1) {
            if (arrList2.contains(arr)) {
                intersection++;
                arrList2.remove(arr);
            }
        }

        union = arrList1.size() + arrList2.size();
        answer = (int)(((float) intersection / (float) union) * 65536);

        return answer;
    }
}
