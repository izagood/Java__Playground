package com.zagood.inflearnthejavatest.member;

import java.util.Optional;

import com.zagood.inflearnthejavatest.domain.Study;

public interface MemberService {
	
	Optional<Member> findById(Long memberId);
	
	void validate(Long memberId);
	
	void notify(Study newStudy);

	void notify(Member member);

}
