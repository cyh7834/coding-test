public class Solution {
    public int solution(String[] friends) {
        int humanLength = friends.length;
        int totalFriend = 0, answer = 0;

        for (int i = 0; i < humanLength; i++) {
            for (int j = 0; j < humanLength; j++) {
                if (i == j)
                    continue;

                // 자신의 직접친구를 센다.
                if (friends[i].charAt(j) == 'Y')
                    totalFriend++;

                // 직접친구가 아닐 때, 해당 사람의 직접친구가 나의 직접친구인지 확인하여 맞다면 친구로 센다.
                else {
                    for (int k = 0; k < humanLength; k++) {
                        if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
                            totalFriend++;
                            break;
                        }
                    }
                }
            }
            answer = Math.max(answer, totalFriend);
            totalFriend = 0;
        }
        return answer;
    }
}
