package test_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coding_test.RecurObject;

public class Tests {


	@Test
	@DisplayName("재귀 테스트")
	void recurTest() {
		RecurObject recur = new RecurObject();
		
		recur.recur(4);
		
		List<String> newList = new ArrayList<>();
		
		
	}
	
	@Test
	@DisplayName("간단 테스트")
	void simpleTest() {

		String a = "ab";

		String substring = a.substring(0, 1);

		System.out.println(substring);

	}
	
	@Test
	@DisplayName("Date 비교 테스트")
	void dateTest() throws ParseException {
		
		String dateType1 = "09:35:00";
		String dateType2 = "10:35:00";
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	    
	    Date offlineAttendTime = timeFormat.parse(dateType1);
	    Date onlineAttendTime = timeFormat.parse(dateType2);

	    int onOffLineTimecompare = offlineAttendTime.compareTo(onlineAttendTime);
		
		
		System.out.println(onOffLineTimecompare);
		
		//숫자로 크기 비교되어 나옴
//		dateType1이 더 빠른 경우 음수
		
	}
	
	@Test
	@DisplayName("정렬 테스트")
	void sortTest() {
		
		
//		// ArrayList 준비
//		ArrayList<String> list = new ArrayList<>(Arrays.asList("C", "A", "B", "a"));
//		System.out.println("원본 : " + list); // [C, A, B, a]
//		// 오름차순으로 정렬
//		Collections.sort(list);
//		System.out.println("오름차순 : " + list); // [A, B, C, a]
//		// 내림차순으로 정렬
//		Collections.sort(list, Collections.reverseOrder());
//		System.out.println("내림차순 : " + list); // [a, C, B, A]
//		// 대소문자 구분없이 오름차순
//		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
//		System.out.println("대소문자 구분없이 오름차순 : " + list); // [a, A, B, C]
//		// 대소문자 구분없이 내림차순
//		Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
//		System.out.println("대소문자 구분없이 내림차순 : " + list); // [C, B, a, A]
//		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(getUP("이경주", "19:27:00", "ON"));
		list.add(getUP("박원숙", "08:32:33", "OFF"));
		list.add(getUP("장순희", "09:34:35", "OFF"));
		list.add(getUP("박유경", "09:54:27", "OFF"));
		list.add(getUP("김부순", "N", "N"));
		list.add(getUP("김경서", "N", "N"));
		list.add(getUP("신성림", "N", "N"));
 
        //ON유피 - 최신
        Comparator<Map<String, Object>> upNewSort = new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2){
            	String attend_time1 = (String) o1.get("attend_gubun");
				String attend_time2 = (String) o2.get("attend_gubun");
				
				if(attend_time2.compareTo(attend_time1) == 0) {
					String attend_gubun_time1 = (String) o1.get("attend_time");
					String attend_gubun_time2 = (String) o2.get("attend_time");
					
					return attend_gubun_time2.compareTo(attend_gubun_time1);
				}else {
					
					return attend_time2.compareTo(attend_time1);
				}
            }
        };
 
        //ON유피 - 오래된
//        Comparator<Map<String, Object>> upOldSort = new Comparator<Map<String, Object>>() {
//            public int compare(Map<String, Object> o1, Map<String, Object> o2){
//            	String attend_time1 = (String) o1.get("attend_time");
//            	String attend_time2 = (String) o2.get("attend_time");
//            	return attend_time1.compareTo(attend_time2);
//            }
//        };
 
        System.out.println("유피 최신");
        Collections.sort(list, upNewSort);
        
        for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
        
//        System.out.println("유피 오래된");
//        
//        Collections.sort(list, upOldSort);
//        
//        for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		
	}
	@Test
	@DisplayName("유니베라 정렬 테스트")
	public void univeraSortTest() {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(getUP("이경주", "08:27:00", "ON"));
		list.add(getUP("김경서", "no_data", "no_data"));
		list.add(getUP("이경주", "19:27:00", "ON"));
		list.add(getUP("이경주", "no_data", "no_data"));
		list.add(getUP("박원숙", "08:32:33", "OFF"));
		list.add(getUP("장순희", "09:34:35", "OFF"));
		list.add(getUP("김부순", "no_data", "no_data"));
		list.add(getUP("박유경", "09:54:27", "OFF"));
		list.add(getUP("신성림", "no_data", "no_data"));
		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		
//		mapListSorting(list, "attend_gubun", "N");
		mapListSorting(list, "up_nm", "desc");
		System.out.println();
		System.out.println("정렬 테스트");
		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		// 이름(String) 오름차순
//		Collections.sort(list, new Comparator<HashMap<String, Object>>() {
//			@Override
//			public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
//				String name1 = (String) o1.get("up_nm");
//				String name2 = (String) o2.get("up_nm");
//				return name1.compareTo(name2);
//			}
//		});
//		System.out.println();
//		System.out.println("이름(String) 오름차순");
//		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		
		// 이름(String) 내림차순
//		Collections.sort(list, new Comparator<HashMap<String, Object>>() {
//			@Override
//			public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
//				String name1 = (String) o1.get("up_nm");
//				String name2 = (String) o2.get("up_nm");
//				return name1.compareTo(name2);
//			}
//		});
//		System.out.println();
//		System.out.println("이름(String) 내림차순");
//		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		// ON유피순
//		Collections.sort(list, new Comparator<HashMap<String, Object>>() {
//			@Override
//			public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
//				String name1 = (String) o1.get("attend_gubun");
//				String name2 = (String) o2.get("attend_gubun");
//				return name2.compareTo(name1);
//			}
//		});
//		System.out.println();
//		System.out.println("ON유피순");
//		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		// 유피순
//		Collections.sort(list, new Comparator<HashMap<String, Object>>() {
//			@Override
//			public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
//				String name1 = (String) o1.get("attend_gubun");
//				String name2 = (String) o2.get("attend_gubun");
//				return name1.compareTo(name2);
//			}
//		});
//		System.out.println();
//		System.out.println("유피순");
//		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		// 오래된 순
//		Collections.sort(list, new Comparator<HashMap<String, Object>>() {
//			@Override
//			public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
//				String name1 = (String) o1.get("attend_time");
//				String name2 = (String) o2.get("attend_time");
//				return name1.compareTo(name2);
//			}
//		});
//		System.out.println();
//		System.out.println("오래된 순");
//		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		// 최신순
//		Collections.sort(list, new Comparator<HashMap<String, Object>>() {
//			@Override
//			public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
//				String name1 = (String) o1.get("attend_time");
//				String name2 = (String) o2.get("attend_time");
//				return name2.compareTo(name1);
//			}
//		});
//		System.out.println();
//		System.out.println("최신순");
//		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		/* 위 함수 모두 테스트 완료 */
		
	}

	public Map<String, Object> getUP(String name, String date, String gubun){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("up_nm", name);
		map.put("attend_time", date);
		map.put("attend_gubun", gubun);
		return map;
		
		
	}
	
	private void mapListSorting(List<Map<String, Object>> mapList, final String key, final String ascDesc) {
		Collections.sort(mapList, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				String key1 = (String) o1.get(key);
				String key2 = (String) o2.get(key);
				
				if(key1.compareTo(key2) == 0) {
					String attend_time1 = (String) o1.get("attend_time");
					String attend_time2 = (String) o2.get("attend_time");
					return attend_time2.compareTo(attend_time1);
				}else {
					if("desc".equals(ascDesc)) {
						return key2.compareTo(key1);
					}else {
						return key1.compareTo(key2);
					}
				}
			}
		});
	}
	
	@Test
	@DisplayName("컴페어 테스트")
	public void compareTest() {
		
		List<String> testList = new ArrayList<>();
		
		testList.add("OFF");
		testList.add("ON");
		
		Comparator<String> test = new Comparator<String>() {
            public int compare(String o1, String o2){
            	System.out.println(o1.compareTo(o2));
            	
				return o1.compareTo(o2);
            }
        };
        
        Collections.sort(testList, test);
	}
}
