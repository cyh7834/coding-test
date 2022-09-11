import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();

        for (String operation : operations) {
            String[] splitOperation = operation.split(" ");

            if (splitOperation[0].equals("I")) {
                int number = Integer.parseInt(splitOperation[1]);
                int listSize = list.size();

                if (listSize == 0)
                    list.add(number);
                else {
                    boolean added = false;

                    for (int i = 0; i < listSize; i++) {
                        if (list.get(i) >= number) {
                            list.add(i, number);
                            added = true;
                            break;
                        }
                    }

                    if (!added)
                        list.add(number);
                }
            }
            else {
                if (!list.isEmpty()) {
                    if (splitOperation[1].equals("1")) {
                        list.removeLast();
                    }
                    else {
                        list.removeFirst();
                    }
                }
            }
        }

        if (list.isEmpty())
            return new int[]{0, 0};
        else
            return new int[]{list.getLast(), list.getFirst()};
    }
}