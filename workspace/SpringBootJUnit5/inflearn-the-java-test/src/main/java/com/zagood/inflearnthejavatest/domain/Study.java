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

	public StudyStatus getStatus() {
		return this.status;
	}
	
	public int getLimit() {
		return this.limit;
	}
	
	public void setOwner(Member owner) {
		this.owner = owner;
	}
}
