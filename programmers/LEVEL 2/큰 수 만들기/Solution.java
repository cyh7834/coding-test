import java.util.*;

public class Solution {
    public String solution(String number, int k) {
        char[] splitedNumber = number.toCharArray();
        Stack<Character> numberStack = new Stack<Character>();
        int splitedNumberSize = splitedNumber.length;
        numberStack.push(splitedNumber[0]);
        int count = 0;

        for (int i = 1; i < splitedNumberSize; i++) {
            while (!numberStack.isEmpty() && numberStack.peek() < splitedNumber[i]
                    && count < k) {
                numberStack.pop();
                count++;
            }
            numberStack.push(splitedNumber[i]);
        }
        String result = "";
        while (!numberStack.isEmpty())
            result = numberStack.pop() + result;

        return result.substring(0, splitedNumberSize - k);
    }
}
