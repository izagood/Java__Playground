package com.zagood.inflearnthejavatest.study;

import java.util.Optional;

import com.zagood.inflearnthejavatest.domain.Study;
import com.zagood.inflearnthejavatest.member.Member;
import com.zagood.inflearnthejavatest.member.MemberNotFoundException;
import com.zagood.inflearnthejavatest.member.MemberService;

public class StudyService {
	
	private final MemberService memberService;
	private final StudyRepository repository; 
	
	public StudyService(MemberService memberService, StudyRepository repository) {
		assert memberService != null;
		assert repository != null;
		
		this.memberService = memberService;
		this.repository = repository;
	}
	
	public Study createNewStudy(Long memberId, Study study) throws MemberNotFoundException {
		Optional<Member> member = memberService.findById(memberId);
		study.setOwner(member.orElseThrow(() -> new IllegalArgumentException("Member dosen't exist for id : " + memberId)));
		return repository.save(study);
	}
	
}
