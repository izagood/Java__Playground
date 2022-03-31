package com.zagood.inflearnthejavatest;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

import com.zagood.inflearnthejavatest.domain.Study;

@ExtendWith(FindSlowTestExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //instance를 1개만 생성하여 다른 메서드가 테스트를 진행할때 상태를 공유함.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //비즈니스 순서대로 테스트를 수행하여야할 때 사용
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)//언더스코어를 공백으로 바꿔줌
class StudyTest {

	@FastTest
//	@Test
	@DisplayName("스터디 만들기")
	@EnabledOnOs({OS.WINDOWS, OS.LINUX})
	@EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
//	@Tag("fast")
//	@EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
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
		
		/*테스트 작성 다른 방법*/
//		Study actual = new Study(10);
//		assertThat(actual.getLimit()).isGreaterThan(0);
		
		/*환경변수가 일치하는 경우에만 테스트 실행*/
		String test_env = System.getenv("TEST_ENV"); //환경변수를 불러오고 정상일때만 실행
		assumeTrue("LOCAL".equals(test_env));
		
		/*조건에 만족하는 경우만 테스트 진행*/
		assumingThat("Server".equals(test_env), () -> {});
		
	}
	
	@SlowTest
//	@Test
//	@Tag("slow")
	@DisabledOnOs({OS.MAC, OS.LINUX})
	void create1() {
		System.out.println("create1");
	}
	
	@RepeatedTest(value = 10, name = "{displayName},  {currentRepetition}/{totalRepetitions}")
	@DisplayName("스터디 만들기 반복")
	@Disabled
//	@Tag("fast")
	void repeatTest(RepetitionInfo repetitionInfo) {
		System.out.println("{displayName}" + repetitionInfo.getCurrentRepetition() + "/"
				+ repetitionInfo.getTotalRepetitions());
	}
	
	@BeforeAll
	static void beforeAll() { //@TestInstance를 사용하여 instance를 1개만 사용할 경우 static을 제거할 수 있다.
		System.out.println("beforeAll");
		
	}
	
	@AfterAll
	static void afterAll() { //@TestInstance를 사용하여 instance를 1개만 사용할 경우 static을 제거할 수 있다.
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
	
	@DisplayName("순서1")
	@Order(1)
	void seqTest1() {
		
	}
	@DisplayName("순서2")
	@Order(2)
	void seqTest2() {
		
	}

}
