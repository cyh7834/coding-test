package topcoder;

public class Solution {
	public long solution(int[] numbers) {
        long answer = 0, sum = 0;
        int numberLength = numbers.length;
       
        for (int i = 0; i < numberLength; i++) {
        	sum = numbers[i] + 1;
        	for (int j = 0; j < numberLength; j++) {
        		if (i == j)
        			continue;
        		
        		sum *= numbers[j];
        	}
        	answer = Math.max(answer, sum);
        	sum = 0;
        }
        
        return answer;
    }
}
