package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String solution(int[] numbers) {
		int numberLength = numbers.length;
        Integer[] integerNumber = new Integer[numberLength];
        
        for (int i = 0; i < numberLength; i++)
        	integerNumber[i] = numbers[i];
        
        Arrays.sort(integerNumber, new Comparator<Integer>() {

        	//정렬 기준을 커스텀하기 위해 Comparator를 구현했다.
        	//숫자 값 자체의 비교가 아닌 문자열로 연결 시에 큰 수를 만들어야 하기 때문에 두 수를 연결하여 비교 후 정렬한다.
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1.toString();
				String s2 = o2.toString();
				
				return (s2+s1).compareTo(s1+s2);
			}
        	
        });
        
        //여러번의 문자열 연산이 수행되기 때문에 StringBuilder를 사용했다.
        StringBuilder result = new StringBuilder();
        for (int number : integerNumber)
        	result.append(number);
        
        //모든 데이터가 0일시에 예외처리
        if (result.substring(0, 1).equals("0"))
        	return "0";
        
        return result.toString();
    }
}
