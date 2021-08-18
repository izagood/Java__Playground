package programmers_proj.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import programmers_proj.problems.hash.Participant;
import programmers_proj.problems.hash.PhoneBook;

public class Tests {
	
	@Test
	@DisplayName("함수형 프로그래밍 연습")
	public void functionalTest() {
		
		// () -> {}
		
	}
	
	@Test
	@DisplayName("Stream 연습")
	void streamTest() {
		
		
		int[] phone_book_num = {119, 97674223, 1195524421};
		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] participants = {"leo", "kiki", "eden"};
		String[] test = {"test1", "test2", "test3"};
		
		
		/* array를 Map으로 변환하는 코드
		 *
		 * Map<String, Long> participantMap = Arrays.asList(participant).stream()
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 */
//		List<String> names = Arrays.asList(participants);
//		List<String> numbers = Arrays.asList(phone_book);
////		System.out.println(names);
//		
////		Stream<String> stream = names.stream().filter(name -> name.contains("11"));
//		Stream<String> stream = names.stream().peek(System.out::println).map(String::toUpperCase);
////		System.out.println(stream);
//		
//		int sum = IntStream.of(1, 3, 5, 7, 9)
//				  .peek(System.out::println)
//				  .sum();
//		
//		/* int Optional 객체 */
//		OptionalInt min = IntStream.of(phone_book_num).min();
//		System.out.println(min.getAsInt());
//		
//		/* int 출력 */
//		IntStream.of(phone_book_num).min().ifPresent(System.out::println);
		
		
//		Arrays.stream(participants).forEach(System.out::println);
		
		/*--------------------------------------------------------------*/
		
		
		List<String> list = Arrays.asList(test);
		
		Optional<String> findFirst = list.stream()
		  .filter(el -> {
		    System.out.println("filter() was called.");
		    return el.contains("4");
		  })
		  .map(el -> {
		    System.out.println("map() was called.");
		    return el.toUpperCase();
		  })
		  .findFirst();
		
		findFirst.ifPresent(System.out::println);
		
		/*--------------------------------------------------------------*/
		
//		List<String> list = Arrays.asList("Apple","Banana","Melon","Grape","Strawberry");
//
//		System.out.println(list);
//		
//		String collect = list.stream().map(String::toUpperCase).collect(Collectors.joining(" "));
//		
//		System.out.println(collect);
//		
//		List<String> collect2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
//		
//		System.out.println(collect2);
	}
	
	@Test
	@DisplayName("완주하지 못한 선수")
	void participant() {
		Participant participant = new Participant();
		
		String[] participants = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String solution = participant.solution(participants, completion);
		System.out.println(solution);
		
	}
	
	@Test
	@DisplayName("전화번호 목록")
	void phoneBook() {
		
		PhoneBook phoneBook = new PhoneBook();
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		boolean solution = phoneBook.solution(phone_book);
		System.out.println(solution);
		
	}
}
