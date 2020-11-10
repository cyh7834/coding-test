import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> combination = new HashMap<>();

        for (String[] eachClothes : clothes) {
            int num = 1;
            if (combination.containsKey(eachClothes[1]))
                num = combination.get(eachClothes[1]) + 1;

            combination.put(eachClothes[1], num);
        }

        for (String key : combination.keySet()) {
            int value = combination.get(key);
            answer *= value + 1;
        }
        return answer - 1;
    }
}
