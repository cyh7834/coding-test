package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public int solution(int[] priorities, int location) {
        List<Integer> priList = new ArrayList<Integer>();
        
        for(int priority : priorities)
        	priList.add(priority);

        //�켱������ ���� ������ �����Ѵ�.
        Collections.sort(priList, Collections.reverseOrder());
        
        int index = 0;
        boolean isFinish = false;
        int answer = 0;
        
        //�μ⸦ ��û�� ������ ��� ������ ����Ѵ�.
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
