package com.zagood.inflearnthejavatest.study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito.Then;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zagood.inflearnthejavatest.domain.Study;
import com.zagood.inflearnthejavatest.member.Member;
import com.zagood.inflearnthejavatest.member.MemberService;

@ExtendWith(MockitoExtension.class) //이게 있어야 동작함
public class StudyServiceTest {

	@Mock
	MemberService memberService;
	
	@Mock
	StudyRepository studyRepository;
	
	@Test
	void createStudyService(@Mock MemberService memberService,
							@Mock StudyRepository studyRepository) {
		
		StudyService studyService = new StudyService(memberService, studyRepository);
		assertNotNull(studyService);
		
		Member member = new Member();
		member.setId(1L);
		member.setEmail("ljbfif50@gmail.com");
		
		when(memberService.findById(any()))
			.thenReturn(Optional.of(member))
			.thenThrow(new RuntimeException())
			.thenReturn(Optional.empty())
		;
		
		Optional<Member> findById = memberService.findById(1L);
		assertEquals("ljbfif50@gmail.com", findById.get().getEmail());
		
		assertThrows(RuntimeException.class, () -> {
			memberService.findById(2L);
		});
		
		assertEquals(Optional.empty(), memberService.findById(3L));
		
		
	}
	
	@Test
	void practiceTest1(@Mock MemberService memberService,
						@Mock StudyRepository studyRepository) {
		StudyService studyService = new StudyService(memberService, studyRepository);
		assertNotNull(studyService);
		
		Study study = new Study(10, "테스트");
		
		Member member = new Member();
		member.setId(1L);
		member.setEmail("ljbfif50@gmail.ccom");
		
		//memberService mocking
		when(memberService.findById(1L))
			.thenReturn(Optional.of(member))
		;
		
		//studyRepository mocking
		when(studyRepository.save(study))
			.thenReturn(study)
		;
		
		
		studyService.createNewStudy(1L, study);
		assertNotNull(study.getOwner());
		assertEquals(member, study.getOwner());
		
		/*테스트하고자 하는 코드는
		 * study.setOwner(member.orElseThrow(() -> new IllegalArgumentException("Member dosen't exist for id : " + memberId)));
		 * 해당 함수에 memberService, studyService의 구현체가 없기 때문에 mocking 하는 것
		 */
	}
	
	@Test
	@DisplayName("기존 형식의 mockito 사용")
	void practiceTest2(@Mock MemberService memberService,
					@Mock StudyRepository studyRepository) {
		/* Given 주어진 상황*/
		StudyService studyService = new StudyService(memberService, studyRepository);
		assertNotNull(studyService);
		
		Study study = new Study(10, "테스트");
		
		Member member = new Member();
		member.setId(1L);
		member.setEmail("ljbfif50@gmail.ccom");
		
		//memberService mocking
		when(memberService.findById(1L)).thenReturn(Optional.of(member));
		//studyRepository mocking
		when(studyRepository.save(study)).thenReturn(study);
		
		/* When 뭔가를 하면 */
		studyService.createNewStudy(1L, study);
		
		/* Then 이렇게 될 것 이다. */
		assertEquals(member, study.getOwner());
		
		verify(memberService, times(1)).notify(study);
		
//		verifyNoMoreInteractions(memberService);
		
		verify(memberService, times(1)).notify(member);
		verify(memberService, never()).validate(any());
		
		InOrder inOrder = inOrder(memberService);
		inOrder.verify(memberService).notify(study);
		
		verifyNoMoreInteractions(memberService); 
		//verify(memberService, times(1)).notify(study);
		//verify(memberService, times(1)).notify(member);
		// 위쪽에서 이미 호출을 2번 하고 검사하기 때문에 이렇게 검사하면 테스트가 제대로 되지 않는다.
		
		inOrder.verify(memberService).notify(member);
	}
	
	@Test
	@DisplayName("BDD 형식의 mockito 사용")
	void practiceTest3(@Mock MemberService memberService,
			@Mock StudyRepository studyRepository) {
		/* Given 주어진 상황*/
		StudyService studyService = new StudyService(memberService, studyRepository);
		assertNotNull(studyService);
		
		Study study = new Study(10, "테스트");
		
		Member member = new Member();
		member.setId(1L);
		member.setEmail("ljbfif50@gmail.ccom");
		
		// 위 코드를 Given 자리에 mokito의 when을 사용하는게 BDD 스타일에 맞지 않기 때문에 Given으로 변경
		given(memberService.findById(1L)).willReturn(Optional.of(member));
		given(studyRepository.save(study)).willReturn(study);
		
		/* When 뭔가를 하면 */
		studyService.createNewStudy(1L, study);
		
		/* Then 이렇게 될 것 이다. */
		assertEquals(member, study.getOwner());
		
		then(memberService).should(times(1)).notify(study);
		then(memberService).should(times(1)).notify(member);
		
		then(memberService).shouldHaveNoMoreInteractions();
		
		
	}
}
