package programmers_proj.problems.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
	
	/* 풀이 방법 
	 * 
	 * 하나의 요소가 배열의 다른 요소의 접두어 인지 파악 -> 반복
	 * 
	 * 이중 for문
	 * 
	 * List<String> result2 = list1.stream()
	 * .filter(str -> list2.stream().anyMatch(Predicate.isEqual(str)))
	 * .collect(Collectors.toList()); 
	 * 
	 * result2.stream().forEach(System.out::print);
	 * 
	 * public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        List<String> numberList = Arrays.asList(phone_book);
        
        for(String number1 : numberList){
        	int count = 0;
        	
        	for(String number2 : numberList) {
        		boolean startsWith = number2.startsWith(number1);
        		if(startsWith == true ) {
        			count++;
        		}
        		
        		if(count == 2) {
        			answer = false;
        			break;
        		}
        	}
        }
        
        return answer;
    }
	 * 
	 * 동일하게 수행되지만 Hash를 사용하는것이 검색하는데 압도적인 성능을 보인다.
	 * key에 값을 넣고 찾을때만 성능이 좋다.
	 * value를 찾을 때는 성능이 좋지 않다.
	 */
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        
        Map<String, Integer> map = new HashMap<>();
        
        Integer index = 0;
        
        for(String number : phone_book) {
        	
        	int length = number.length();
        	
        	for(int i=1; i<length; i++) {
        		map.put(number.substring(0, i), index);
        		index++;
        	}
        }
        
        for(String number : phone_book) {
        	boolean containsKey = map.containsKey(number);
        	
        	if(containsKey == true) {
        		answer = false;
        	}
        }
        
        
        return answer;
    }
	
}
