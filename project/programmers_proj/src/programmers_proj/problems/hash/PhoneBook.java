package programmers_proj.problems.hash;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
	 */
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        List<String> numberList = Arrays.asList(phone_book);
        
        Map<String, String> answerMap = new HashMap<>();
        
        numberList.stream().forEach(part -> {
	    	answerMap.put(part, part.);
	    });
        
        System.out.println(answerMap);
        
        
        return answer;
    }
	
}
