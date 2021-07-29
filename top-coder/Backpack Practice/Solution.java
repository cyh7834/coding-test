public class Solution {
	public int solution(int[][] obj) {
        int objSize = obj.length;
        int result = 0;
        
        for (int i = 0; i < objSize; i++) {
            boolean[] selected = new boolean[objSize];
            result = Math.max(result, dfs(i, obj, selected, 0, 0, 10));
        }
        return result;
    }

    private int dfs(int currentObj, int[][] obj, boolean[] selected
            , int totalWeight, int totalValue, int maxWeight) {
        selected[currentObj] = true;

        if (totalWeight + obj[currentObj][0] > maxWeight) {
            selected[currentObj] = false;

            return totalValue;
        }

        totalWeight += obj[currentObj][0];
        totalValue += obj[currentObj][1];

        int objSize = obj.length;
        int returnValue = 0;

        for (int i = 0; i < objSize; i++) {
            if (selected[i])
                continue;

            returnValue = Math.max(returnValue, dfs(i, obj, selected, totalWeight, totalValue, maxWeight));
        }

        totalWeight -= obj[currentObj][0];
        totalValue -= obj[currentObj][1];
        selected[currentObj] = false;

        return returnValue;
    }
}
