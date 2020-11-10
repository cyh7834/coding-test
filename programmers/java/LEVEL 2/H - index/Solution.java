package programmers;

import java.util.Arrays;

public class Solution {
	public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
        	answer = n - i;
        	
        	if ( (answer <= citations[i]) && answer >= i)
        		return answer;
        	
        	
        }
        return 0;
    }
}
