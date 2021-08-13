package programmers_proj.problems.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 완주하지 못한 선수
 * 20210812
 */
public class Participant {
	
	/* array를 Map으로 변환하는 코드
	 *
	 * Map<String, Long> participantMap = Arrays.asList(participant).stream()
	 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	 */
	
	
	public String solution(String[] participant, String[] completion) {
		
		String answer = "";
	    Map<String, Integer> answerMap = new HashMap<String, Integer>();
	    
	    for(String part : participant){
	        answerMap.put(part, answerMap.getOrDefault(part, 0) + 1);
	    }
	    
	    for(String comp : completion){
	        answerMap.put(comp, answerMap.get(comp) - 1);
	    }
	    
	    for(String key : answerMap.keySet()){
	        if(answerMap.get(key) != 0 ){
	            answer = key;
	            break; 
	        } 
	    }
	    
	    Map<String, Long> participantMap = Arrays.asList(participant).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    
	    return answer;
	}
}
