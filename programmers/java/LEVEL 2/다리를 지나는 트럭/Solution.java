import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int numberOfTrucks = truck_weights.length;
        int numberOfCrossedTruck = 0;
        int truckWeightSum = 0;
        int truckIndex = 0;
        Queue<Integer> bridgeQueue = new LinkedList<Integer>();
        ArrayList<Integer> timeList = new ArrayList<Integer>();

        while(numberOfCrossedTruck < numberOfTrucks) {
            // 트럭이 다리를 지났으면 카운트를하고 무게를 줄인다.
            if ( (timeList.size() > 0) && (timeList.get(0) == bridge_length) ) {
                truckWeightSum -= bridgeQueue.poll();
                timeList.remove(0);
                numberOfCrossedTruck++;
            }

            //트럭이 올라갈 수 있는 상황이라면 올린다.
            if ((truckWeightSum + truck_weights[truckIndex] <= weight)
                    && (bridgeQueue.size() < bridge_length)) {
                truckWeightSum += truck_weights[truckIndex];
                timeList.add(0);
                bridgeQueue.add(truck_weights[truckIndex]);
                truckIndex++;
            }
            for (int i = 0; i < timeList.size(); i++)
                timeList.set(i, timeList.get(i) + 1);

            if (truckIndex == numberOfTrucks) {
                answer += bridge_length + 1;
                break;
            }
            answer++;
        }

        return answer;
    }
}
