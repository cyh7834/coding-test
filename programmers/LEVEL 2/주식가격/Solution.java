package programmers;

public class Solution {
	public int[] solution(int[] prices) {
        int priceLength = prices.length;
		int[] answer = new int[priceLength];
        int time = 0, index = 0;
        
        for (int i = 0; i < priceLength - 1; i++) {
        	for (int j = i + 1; j < priceLength; j++) {
        		time++;
        		
        		if (prices[i] > prices[j] && prices[i] != prices[j]) 
        			break;
        	}
        	answer[index++] = time;
        	time = 0;
        }
        return answer;
    }
}
