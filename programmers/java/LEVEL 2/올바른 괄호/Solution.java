import java.util.Stack;

public class Solution {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (char data : charArray) {
            if (stack.empty()) {
                stack.push(data);
                continue;
            }
            
            if (stack.peek() == 40 && data == 41) {
                stack.pop();
            }
            else
                stack.push(data);
        }

        return stack.empty();
    }
}