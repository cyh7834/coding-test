package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public int solution(int[] priorities, int location) {
        List<Integer> priList = new ArrayList<Integer>();
        
        for(int priority : priorities)
        	priList.add(priority);

        //우선순위가 높은 순으로 정렬한다.
        Collections.sort(priList, Collections.reverseOrder());
        
        int index = 0;
        boolean isFinish = false;
        int answer = 0;
        
        //인쇄를 요청한 문서의 출력 순서를 계산한다.
        while(!isFinish) {
        	if (priorities[index] == priList.get(0)) {
        		answer++;
        		
        		if (index == location)
        			isFinish = true;
        		
        		else 
        			priList.remove(0);
        	}
        	index++;
        	
        	if (index == priorities.length)
        		index = 0;
        }
        return answer;
    }
}
