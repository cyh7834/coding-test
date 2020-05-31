public class Solution {
    public String solution(String s) {
        char[] stringArray = s.toCharArray();
        boolean change = true;
        int stringArrayLength = stringArray.length;

        for (int i = 0; i < stringArrayLength; i++) {
            if (change && stringArray[i] >= 97 && stringArray[i] <= 122) {
                stringArray[i] -= 32;
                change = false;
            }
            else if (stringArray[i] == ' ') {
                change = true;
                continue;
            }
            else if (!change && stringArray[i] >= 65 && stringArray[i] <= 90) {
                stringArray[i] += 32;
            }
            change = false;

        }
        return new String(stringArray);
    }
}
