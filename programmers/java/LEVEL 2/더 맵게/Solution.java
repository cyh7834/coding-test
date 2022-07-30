import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int value : scoville) {
            minHeap.add(value);
        }

        int count = 0;
        while (minHeap.peek() < K) {
            Integer minScoville = minHeap.poll();
            Integer nextMinScoville = minHeap.poll();
            Integer newScoville = minScoville + (nextMinScoville * 2);

            minHeap.add(newScoville);

            if (minHeap.size() < 2 && minHeap.peek() < K)
                return -1;

            count++;
        }

        return count;
    }
}