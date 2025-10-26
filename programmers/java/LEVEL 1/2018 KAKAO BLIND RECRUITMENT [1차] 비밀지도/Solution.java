class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int answerIndex = 0;

        for (int i = 0; i < arr1.length; i++) {
            String[] arr1Binary = getBinaryArray(n, arr1[i]);
            String[] arr2Binary = getBinaryArray(n, arr2[i]);
            StringBuilder map = new StringBuilder();

            for (int j = 0; j < arr1Binary.length; j++) {
                map.append((Integer.parseInt(arr1Binary[j]) + Integer.parseInt(arr2Binary[j])) == 0 ? " " : "#");
            }

            answer[answerIndex++] = map.toString();
        }

        return answer;
    }

    private String[] getBinaryArray(int n, int num) {
        return String.format("%" + n + "s", Integer.toBinaryString(num)).replace(' ', '0').split("");
    }
}