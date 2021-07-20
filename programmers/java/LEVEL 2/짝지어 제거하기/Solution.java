import java.util.Stack;

public class Solution {
    public int solution(String s)
    {
        int strLength = s.length();
        char[] charArr = s.toCharArray();
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < strLength; i++) {
            if (charStack.size() > 0) {
                if (charArr[i] == charStack.peek()) {
                    charStack.pop();
                }
                else
                    charStack.push(charArr[i]);
            }
            else
                charStack.push(charArr[i]);

        }

        return charStack.size() > 0 ? 0 : 1;
    }
}