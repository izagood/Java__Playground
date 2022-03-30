package com.zagood.inflearnthejavatest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)//언더스코어를 공백으로 바꿔줌
class StudyTest {

	@Test
	@DisplayName("스터디 만들기")
	void create() {
		Study study = new Study(10);
		
		/*기본적인 테스트*/
//		assertNotNull(study);
//		assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
//		assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 인원은 0보다 커야 한다.");
		
		/*한번에 모두 테스트*/
//		assertAll(
//				() -> assertNotNull(study),
//				() -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
//				() -> assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 인원은 0보다 커야 한다.")
//		);
		
		/*예외 테스트*/
//		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
//		assertEquals("limit는 0보다 커야 한다.", exception.getMessage());
		
		/*타임아웃 테스트 - 100ms가 넘어도 전체 모두 수행*/
//		assertTimeout(Duration.ofMillis(100), () ->{
//			new Study(10);
//			Thread.sleep(300);
			// 시간이 걸리더라도 아래의 경우 같은 예외는 없어서 조금 더 안전함.
//		});
		
		/*타임아웃 테스트 - 100ms가 넘으면 수행 종료*/
//		assertTimeoutPreemptively(Duration.ofMillis(100), () ->{
//			new Study(10);
//			Thread.sleep(300);
//			// TODO ThreadLocal를 사용하는 경우 예상치 못한 결과가 나올 수 있다.
//			// ThreadLocal이 공유가 안 되어 rollback이 안 되고 DB에 반영이 될 수도 있다.
//			// Thread를 사용하는 경우 주의
//		});
		
		Study actual = new Study(10);
		assertThat(actual.getLimit()).isGreaterThan(0);
	}
	
	@Test
	void create1() {
		System.out.println("create1");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
		
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
		
	}
	
	@BeforeEach
	void beforeEach() {
		
		System.out.println("beforeEach");
	}
	
	@AfterEach
	void afterEach() {
		
		System.out.println("afterEach");
	}

}
