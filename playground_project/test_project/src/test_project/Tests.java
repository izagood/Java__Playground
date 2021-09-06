package test_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coding_test.RecurObject;

public class Tests {


	@Test
	@DisplayName("재귀 테스트")
	void recurTest() {
		RecurObject recur = new RecurObject();
		
		recur.recur(4);
		
		List<String> newList = new ArrayList<>();
		
		
	}
	
	@Test
	@DisplayName("간단 테스트")
	void simpleTest() {

		String a = "ab";

		String substring = a.substring(0, 1);

		System.out.println(substring);

	}
}
