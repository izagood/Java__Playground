package programmers_proj.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spy {

	/**
	 * 각 그룹별로 나눠서 경우의 수를 계산해야 한다.
	 * 
	 * 예를 들어
	 * 
	 * 그룹이 4개 일때
	 * (A 그룹 : 2개,
	 *  B 그룹 : 3개, 
	 *  C 그룹 : 2개, 
	 *  D 그룹 : 3개, )
	 * 
	 * 1개 10 C 1 == 10
	 * 2개 2 C 1 * 8 C 1 == 2 * 8
	 * 3개 2 C 1 * 3 C 1 * 5 C 1 == 2 * 3 * 5
	 * 4개 2 C 1 * 3 C 1 * 2 C 1 * 3 C 1 ==  2 * 3 * 2 * 3
	 * 
	 * 각 개수에 대한 경우를 모두 더한다.
	 * 
	 * @param clothes
	 * @return
	 */
	public int solution(String[][] clothes) {
		
        Map<String, Integer> clothesMap = new HashMap<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        
        for(String[] itemArr : clothes) {
        	clothesMap.put(itemArr[1], clothesMap.getOrDefault(itemArr[1], 0) + 1);
        }
        
        int groupSize = clothesMap.keySet().size();
        
        int valueSum = 0;
        int[] valueArr = new int[groupSize];
        int index = 0;
        
        for(String key : clothesMap.keySet()) {
        	Integer value = clothesMap.get(key);
        	
        	valueArr[index] = value;
        	
        	index++;
        	
        	valueSum = valueSum + value;
        }
        
        for(int i=0; i<groupSize; i++) {
        	int minusSum = 0;
        	
        	List<Integer> list = new ArrayList<>();
        	
        	if(i != 0) {
        		for(int j=0; j<i; j++) {
        			minusSum = minusSum + valueArr[j];
        		}
        	}
        	list.add(valueSum - minusSum);
        	
        	if(i != 0) {
        		for(int k=0; k<i; k++) {
        			list.add(valueArr[k]);
        		}
        	}
        	System.out.println(list);
        	groupMap.put(i, list);
        }
        
        System.out.println(groupMap);
        int total = 0;
        
        for(Integer group : groupMap.keySet()) {
        	List<Integer> list = groupMap.get(group);
        	
        	int tempMultiple = 1;
        	
        	for(Integer num : list) {
        		tempMultiple = tempMultiple * num;
        	}
        	total = total + tempMultiple;
        }
        
        return total;
    }
}
