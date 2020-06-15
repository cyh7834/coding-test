import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;

        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();

            if (queue.contains(city)) {
                answer += 1;
                queue.remove(city);
            }
            else if (queue.size() > cacheSize){
                answer += 5;
                queue.poll();
            }
            else
                answer += 5;

            queue.add(city);
        }

        return answer;
    }
}
