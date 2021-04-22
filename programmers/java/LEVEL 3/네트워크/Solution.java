class Solution {
    public static int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, visit, computers);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int computer, boolean[] visit, int[][] computers) {
        visit[computer] = true;
        int totalComputerLength = computers.length;

        for (int i = 0; i < totalComputerLength; i++) {
            if (computers[computer][i] == 1 && !visit[i]) {
                dfs(i, visit, computers);
            }
        }
    }
}