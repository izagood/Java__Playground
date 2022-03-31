package com.zagood.inflearnthejavatest.member;

import java.util.Optional;

public interface MemberService {
	
	Optional<Member> findById(Long memberId) throws MemberNotFoundException;

}
