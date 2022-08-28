import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLength = s.length();
        StringBuilder stringBuilder = new StringBuilder().append(s);

        for (int i = 0; i < sLength; i++) {
            stringBuilder.append(stringBuilder.substring(0, i)).delete(0, i);

            if (checkRightString(stringBuilder.toString()))
                answer++;

            stringBuilder.setLength(0);
            stringBuilder.append(s);
        }
        return answer;
    }

    public boolean checkRightString (String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (stack.empty()) {
                stack.push(aChar);

                continue;
            }

            Character prevChar = stack.peek();

            if ((prevChar == '[' && aChar == ']') || (prevChar == '{' && aChar == '}') 
                    || (prevChar == '(' && aChar == ')')) {
                stack.pop();
            }
            else {
                stack.push(aChar);
            }
        }

        return stack.size() == 0;
    }
}