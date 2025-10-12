class Solution {
    public int[] solution(String s) {
        int length = s.length();
        int[] answer = new int[length];
        answer[0] = -1;

        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            String substring = s.substring(0, i);
            int lastIndex = substring.lastIndexOf(c);

            answer[i] = lastIndex == -1 ? -1 : i - lastIndex;
        }
        
        return answer;
    }
}