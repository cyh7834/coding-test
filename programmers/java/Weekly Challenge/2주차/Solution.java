import java.util.Arrays;

public class Solution {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        int numberOfStudent = scores.length;

        for (int i = 0; i < numberOfStudent; i++) {
            int selfScore = scores[i][i];
            int[] currentStudentScores = new int[numberOfStudent];
            int totalScore = 0;

            for (int j = 0; j < numberOfStudent; j++) {
                currentStudentScores[j] = scores[j][i];
                totalScore += scores[j][i];
            }

            String grade = getGrade(currentStudentScores, selfScore, totalScore, numberOfStudent);
            answer.append(grade);
        }

        return answer.toString();
    }

    private String getGrade(int[] score, int selfScore, int totalScore, int numberOfStudent) {
        double avg = 0.0;
        Arrays.sort(score);

        if ((score[0] != score[1] && score[0] == selfScore) ||
        (score[numberOfStudent - 1] != score[numberOfStudent - 2] && score[numberOfStudent - 1] == selfScore)) {
            totalScore -= selfScore;
            avg = (double) totalScore / (numberOfStudent - 1);
        }
        else {
            avg = (double) totalScore / numberOfStudent;
        }

        if (avg >= 90)
            return "A";
        else if (avg >= 80)
            return "B";
        else if (avg >= 70)
            return "C";
        else if (avg >= 50)
            return "D";
        else
            return "F";
    }
}
