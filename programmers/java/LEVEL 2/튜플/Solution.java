import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String[]> numberList = getNumberList(s);
        numberList.sort(Comparator.comparingInt(o -> o.length));

        LinkedHashSet<Integer> numberSet = getNumberSet(numberList);

        return numberSetToArray(numberSet);
    }

    private List<String[]> getNumberList(String s) {
        List<String[]> numberList = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        int endIndex = s.indexOf('}');

        while (endIndex != -1) {
            String number = s.substring(1, endIndex);
            numberList.add(number.split(","));

            if (endIndex + 2 > s.length())
                break;

            s = s.substring(endIndex + 2);
            endIndex = s.indexOf('}');
        }
        return numberList;
    }

    private LinkedHashSet<Integer> getNumberSet(List<String[]> numberList) {
        LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();

        for (String[] strings : numberList) {
            for (String stringNumber : strings) {
                numberSet.add(Integer.valueOf(stringNumber));
            }
        }

        return numberSet;
    }

    private int[] numberSetToArray(LinkedHashSet<Integer> numberSet) {
        int[] answer = new int[numberSet.size()];
        int i = 0;

        for (Integer integer : numberSet) {
            answer[i] = integer;
            i++;
        }
        return answer;
    }
}
