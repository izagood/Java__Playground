package com.zagood.inflearnthejavatest.study;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zagood.inflearnthejavatest.member.MemberService;

@ExtendWith(MockitoExtension.class) //이게 있어야 동작함
public class StudyServiceTest {

//	@Mock
//	MemberService memberService;
//	
//	@Mock
//	StudyRepository studyRepository;
	
	@Test
	void createStudyService(@Mock MemberService memberService,
							@Mock StudyRepository studyRepository) {
		StudyService studyService = new StudyService(memberService, studyRepository);
		assertNotNull(studyService);
	}
}
