public class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;

        HashSet<Integer> numberSet = new HashSet<>();
        for (int num : nums) {
            numberSet.add(num);
        }

        return Math.min(n, numberSet.size());
    }
}
