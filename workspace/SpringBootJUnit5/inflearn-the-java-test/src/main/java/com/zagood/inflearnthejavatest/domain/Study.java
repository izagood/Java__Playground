package com.zagood.inflearnthejavatest.domain;

import com.zagood.inflearnthejavatest.member.Member;
import com.zagood.inflearnthejavatest.study.StudyStatus;

public class Study {
	private StudyStatus status = StudyStatus.DRAFT;
	
	private int limit;
	private Member owner;
	
	public Study(int limit) {
		if(limit < 0) {
			throw new IllegalArgumentException("limit는 0보다 커야 한다.");
		}
		
		this.limit = limit;
	}
	
	public Study(int id, String email) {
		if(limit < 0) {
			throw new IllegalArgumentException("limit는 0보다 커야 한다.");
		}
		
		Member member = new Member();
		member.setId(id);
		member.setEmail(email);
		
		this.owner = member;
	}

	public StudyStatus getStatus() {
		return status;
	}

	public void setStatus(StudyStatus status) {
		this.status = status;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

}
