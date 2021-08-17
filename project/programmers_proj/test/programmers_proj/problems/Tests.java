package programmers_proj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import programmers_proj.problems.hash.Participant;
import programmers_proj.problems.hash.PhoneBook;

public class Tests {
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
		
		/* array를 Map으로 변환하는 코드
		 *
		 * Map<String, Long> participantMap = Arrays.asList(participant).stream()
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 */
		
	}
}
