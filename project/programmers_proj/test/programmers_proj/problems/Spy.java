package programmers_proj.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spy {

	/**<알고리즘은 완성했는데 공식이 틀려버렸다......ㅋㅋㅋㅋㅋㅋ>
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
//	public int solution(String[][] clothes) {
//		
//        Map<String, Integer> clothesMap = new HashMap<>();
//        Map<Integer, List<Integer>> groupMap = new HashMap<>();
//        
//        for(String[] itemArr : clothes) {
//        	clothesMap.put(itemArr[1], clothesMap.getOrDefault(itemArr[1], 0) + 1);
//        }
//        
//        int groupSize = clothesMap.keySet().size();
//        
//        int valueSum = 0;
//        int[] valueArr = new int[groupSize];
//        int index = 0;
//        
//        for(String key : clothesMap.keySet()) {
//        	Integer value = clothesMap.get(key);
//        	
//        	valueArr[index] = value;
//        	
//        	index++;
//        	
//        	valueSum = valueSum + value;
//        }
//        
//        for(int i=0; i<groupSize; i++) {
//        	int minusSum = 0;
//        	
//        	List<Integer> list = new ArrayList<>();
//        	
//        	if(i != 0) {
//        		for(int j=0; j<i; j++) {
//        			minusSum = minusSum + valueArr[j];
//        		}
//        	}
//        	list.add(valueSum - minusSum);
//        	
//        	if(i != 0) {
//        		for(int k=0; k<i; k++) {
//        			list.add(valueArr[k]);
//        		}
//        	}
//        	System.out.println(list);
//        	groupMap.put(i, list);
//        }
//        
//        System.out.println(groupMap);
//        int total = 0;
//        
//        for(Integer group : groupMap.keySet()) {
//        	List<Integer> list = groupMap.get(group);
//        	
//        	int tempMultiple = 1;
//        	
//        	for(Integer num : list) {
//        		tempMultiple = tempMultiple * num;
//        	}
//        	total = total + tempMultiple;
//        }
//        
//        return total;
//    }
	/**
	 * 
	 * 알고리즘
	 * 
	 * A그룹 1개
	 * B그룹 2개
	 * C그룹 1개
	 * 
	 * 1개 : 1C1 + 2C1 + 1C1 = 4
	 * 2개 : (1C1 * 2C1) + (2C1 * 1C1) + (1C1 * 1C1) = 5
	 * 3개 : 1C1 * 2C1 * 1C1 = 3 
	 * 
	 * @param clothes
	 * @return
	 */
	public int solution(String[][] clothes) {
		int answer = 0;
        
	    Map<String, Integer> clothesMap = new HashMap<>();
		Map<Integer, List<Integer>> groupMap = new HashMap<>();
		  
		for(String[] itemArr : clothes) {
		  	clothesMap.put(itemArr[1], clothesMap.getOrDefault(itemArr[1], 0) + 1);
		}
		
		System.out.println(clothesMap);
		
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
			List<Integer> list = new ArrayList<>();
			/* i=0 : 2 + 3 + 2 + 3
			 * i=1 : 2*3 + 2*2 + 2*3 +3*2 + 3*3 + 2*3
			 * i=2 : 2*3*2 + 2*3*3 + 2*2*3 + 3*2*3 
			 * i=3 : 2*3*2*3
			 */
			
			//i=0
			if(i == 0) {
				for(int j=0; j<groupSize; j++) {
					list.add(valueArr[j]);
				}
			}
			
			//i=1
			if(i == 1) {
				for(int j=0; j<groupSize; j++) {
					for(int k=j + 1; k<groupSize; k++) {
						list.add(valueArr[j] * valueArr[k]);
					}
				}
			}
			
			//i=2
			if(i == 2) {
				for(int j=0; j<groupSize; j++) {
					for(int k=j + 1; k<groupSize; k++) {
						for(int l= k+1;l<groupSize; l++) {
							list.add(valueArr[j] * valueArr[k] * valueArr[l]);
						}
					}
				}
			}
			
			//i=3
			if(i == 3){
				for(int j=0; j<groupSize; j++) {
					for(int k=j + 1; k<groupSize; k++) {
						for(int l= k+1;l<groupSize; l++) {
							for(int m=l+1; m<groupSize; m++) {
								list.add(valueArr[j] * valueArr[k] * valueArr[l] * valueArr[m]);
							}
						}
					}
				}
			}
			
			System.out.println(list);
			
			groupMap.put(i, list);
		}
		
		int totalSum = 0;
		for(Integer group : groupMap.keySet()) {
			List<Integer> list = groupMap.get(group);
			for(Integer num :list) {
				totalSum = totalSum + num;
			}
		}
		System.out.println(totalSum);
        
        return answer;
    }
}
