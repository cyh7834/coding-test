package programmers;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostHashSet = new HashSet<Integer>();
		Set<Integer> reserveHashSet = new HashSet<Integer>();

		for (int lostData : lost) 
			lostHashSet.add(lostData);
		
		for (int reserveData : reserve) {
			if (!lostHashSet.contains(reserveData))
        		reserveHashSet.add(reserveData);
        	else
        		lostHashSet.remove(reserveData);
		}

		//체육복을 빌려줄 수 있는 학생이 존재할 시 빌려준다.
		reserveHashSet.forEach(data -> {
			if (lostHashSet.contains(data - 1)) 
        		lostHashSet.remove(data - 1);
        	
        	else if (lostHashSet.contains(data + 1)) 
        		lostHashSet.remove(data + 1);
		});
        
        return n - lostHashSet.size();
    }
}
