package programmers;

public class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
        int phoneBookLength = phone_book.length;
        
        for (int i = 0; i < phoneBookLength; i++) {
        	for (int j = 0; j < phoneBookLength; j++) {
        		int phoneLength = phone_book[i].length();
        		int otherPhoneLength = phone_book[j].length();
        		
        		// 같은 값을 비교하거나, 접두어 비교대상이 아닐 시 건너뛴다.
        		if (i == j || phoneLength > otherPhoneLength)
        			continue;
                
        		String phoneSubString = phone_book[j].substring(0, phoneLength);
        		
        		// 접두어를 확인한다.
        		if (phone_book[i].equals(phoneSubString))
        			return false;
        	}
        }
        
        return answer;
    }
}
