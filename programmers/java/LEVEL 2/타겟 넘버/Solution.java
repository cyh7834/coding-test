class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target,0, 0, 0);
    }
    public int dfs(int[] numbers, int target, int index, int total, int result) {
        if (numbers.length == index) {
            return total == target ? 1 : 0;
        }

        return dfs(numbers, target, index + 1, total + numbers[index], result)
            + dfs(numbers, target, index + 1, total + (numbers[index] * -1), result);
    }
}