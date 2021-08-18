package programmers_proj.problems.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
	    
	    /*------------ 기본 답안 ------------*/
	    
		/*
		 * for(String part : participant){ answerMap.put(part,
		 * answerMap.getOrDefault(part, 0) + 1); }
		 * 
		 * for(String comp : completion){ answerMap.put(comp, answerMap.get(comp) - 1);
		 * }
		 * 
		 * for(String key : answerMap.keySet()){ if(answerMap.get(key) != 0 ){ answer =
		 * key; break; } }
		 */
	    
	    /*------------ stream을 활용한 답안 ------------*/
	    Arrays.stream(participant).forEach(part -> {
	    	answerMap.put(part, answerMap.getOrDefault(part, 0) + 1);
	    });
	    
	    Arrays.stream(completion).forEach(comp -> {
	    	answerMap.put(comp, answerMap.get(comp) - 1);
	    });
	    
	    Optional<String> findFirst = answerMap.entrySet().stream()
	    		.filter(key -> key.getValue() != 0)
	    		.map(Map.Entry::getKey)
	    		.findFirst();
	    
	    if(findFirst.isPresent()) {
	    	answer = findFirst.get();
	    }
	    
	    return answer;
	}
}
