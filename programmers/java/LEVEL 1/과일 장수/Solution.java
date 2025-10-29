class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int scoreLength = score.length;
        Integer[] boxedScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedScore, Comparator.reverseOrder());

        for (int i = 0; i < scoreLength - (m - 1); i += m) {
            answer += boxedScore[i + (m - 1)] * m;
        }

        return answer;
    }
}