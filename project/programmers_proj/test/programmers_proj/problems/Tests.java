package programmers_proj.problems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import forEachUtil.CustomTakeWhile;
import programmers_proj.problems.hash.Participant;
import programmers_proj.problems.hash.PhoneBook;
import programmers_proj.problems.hash.Product;
import programmers_proj.problems.hash.Spy;
import programmers_proj.problems.kakao.t2021.NewId;

public class Tests {

	@Test
	@DisplayName("함수형 프로그래밍 연습")
	public void functionalTest() {

		// () -> {}

		Optional<String> opStr1 = Optional.of("first string");
		Optional<String> opStr2 = Optional.of("second string");
		Optional<String> filtered1 = opStr1.filter(s -> s.contains("first"));
		Optional<String> filtered2 = opStr2.filter(s -> s.contains("first"));
		filtered1.ifPresent(System.out::println);
		filtered2.ifPresent(System.out::println);

	}

	@Test
	@DisplayName("forEach break문 안됨")
	public void forEachBreakTest() {

		/* java8의 forEach는 break가 불가능 */

		int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(10).toArray();

		List<Integer> readList = new ArrayList<>();
		List<Integer> MatchList = new ArrayList<>();

		Arrays.stream(randomIntsArray).forEach(item -> {
			if (item < 50) {
				System.out.println("매칭된 숫자: " + item);
				MatchList.add(item);
				if (item < 10) {
					System.out.println("break");
				}
			}
			readList.add(item);
		});
		System.out.println(
				"모든 숫자 List: " + Arrays.stream(randomIntsArray).collect(ArrayList::new, List::add, List::addAll));
		System.out.println("매칭된 숫자 List: " + MatchList);
		System.out.println("읽은 숫자 List: " + readList);

	}

	@Test
	@DisplayName("forEach break문 커스텀")
	public void forEachCustomTest() {

		/* break문을 커스텀 하여 사용 */

		int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();

		List<Integer> readList = new ArrayList<>();
		List<Integer> MatchList = new ArrayList<>();

		List<Integer> collect = CustomTakeWhile.takeWhile(Arrays.stream(randomIntsArray).boxed().filter(item -> {
			System.out.print("현재 숫자: " + item + "  ");
			readList.add(item);
			return item < 50;
		}), item -> {
			if (item < 10) {
				System.out.println("break");
				return false;
			}
			System.out.println("매칭 숫자: " + item);
			MatchList.add(item);
			return true;
		}).collect(Collectors.toList());
		System.out.println("collect List : " + collect);

		System.out.println(
				"===================================================================================================");
		System.out.println(
				"모든 숫자 List: " + Arrays.stream(randomIntsArray).collect(ArrayList::new, List::add, List::addAll));
		System.out.println(
				"모든 숫자: " + Arrays.stream(randomIntsArray).collect(ArrayList::new, List::add, List::addAll).size());
		System.out.println("매칭된 숫자 List: " + MatchList);
		System.out.println("읽은 숫자 List: " + readList);

	}

	@Test
	@DisplayName("Stream 연습")
	void streamTest() {

		int[] phone_book_num = { 119, 97674223, 1195524421 };
		String[] phone_book = { "119", "97674223", "1195524421" };
		String[] participants = { "leo", "kiki", "eden" };
		String[] test = { "test1", "test2", "test3" };

		/*
		 * array를 Map으로 변환하는 코드
		 *
		 * Map<String, Long> participantMap = Arrays.asList(participant).stream()
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 */

		/*--------------------------------------------------------------*/
//		List<String> names = Arrays.asList(participants);
//		List<String> numbers = Arrays.asList(phone_book);
		/*--------------------------------------------------------------*/
//		
//		Stream<String> stream = names.stream().filter(name -> name.contains("11"));
		/*--------------------------------------------------------------*/

//		Stream<String> stream = names.stream().peek(System.out::println).map(String::toUpperCase);

		/*--------------------------------------------------------------*/
//		int sum = IntStream.of(1, 3, 5, 7, 9)
//				  .peek(System.out::println)
//				  .sum();
//		
		/*--------------------------------------------------------------*/
//		/* int Optional 객체 */
//		OptionalInt min = IntStream.of(phone_book_num).min();
//		System.out.println(min.getAsInt());
//		
		/*--------------------------------------------------------------*/
//		/* int 출력 */
//		IntStream.of(phone_book_num).min().ifPresent(System.out::println);

		/*--------------------------------------------------------------*/

//		Arrays.stream(participants).forEach(System.out::println);

		/*--------------------------------------------------------------*/

//		List<String> list = Arrays.asList(test);
//
//		Optional<String> findFirst = list.stream().filter(el -> {
//			System.out.println("filter() was called.");
//			return el.contains("4");
//		}).map(el -> {
//			System.out.println("map() was called.");
//			return el.toUpperCase();
//		}).findFirst();
//
//		findFirst.ifPresent(System.out::println);

		/*--------------------------------------------------------------*/

//		List<String> list = Arrays.asList("Apple","Banana","Melon","Grape","Strawberry");
//
//		System.out.println(list);
//		
//		String collect = list.stream().map(String::toUpperCase).collect(Collectors.joining(" "));
//		
//		System.out.println(collect);
//		
//		List<String> collect2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
//		
//		System.out.println(collect2);
		/*--------------------------------------------------------------*/

//		List<String> collect = Stream.generate(() -> "test").limit(5).collect(Collectors.toList());
//		System.out.println(collect);

		/*--------------------------------------------------------------*/

//		List<String> parallelList = IntStream.generate(() -> new Random().nextInt(100)).limit(100)
//		.boxed()
//		.map(el -> String.valueOf(el))
//		.collect(Collectors.toList());
//		// 병렬 스트림 생성
//		Stream<String> parallelStream = parallelList.parallelStream();
//
//		// 병렬 여부 확인
//		boolean isParallel = parallelStream.isParallel();
//		
//		System.out.println(isParallel);
//		
//		
//		boolean isMany = parallelStream
//				  .map(item -> Integer.parseInt(item) * 10)
//				  .anyMatch(amount -> amount > 200);
//		
//		System.out.println(isMany);
		/*--------------------------------------------------------------*/

//		int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
//		Arrays.stream(randomIntsArray).parallel();

		/*--------------------------------------------------------------*/

//		List<Product> productList = new ArrayList<>();
//		
//		IntStream.generate(() -> new Random().nextInt(100)).limit(100)
//		.boxed()
//		.forEach(el -> {
//			Product product = new Product();
//			product.setItem("item" + String.valueOf(el));
//			product.setPrice(el);
//			productList.add(product);
//		});
//		
//		
//		Stream<String> stream = 
//				  productList.stream()
//				  .map(Product::getItem);
//		
//		System.out.println(stream.collect(Collectors.toList()));
		/*--------------------------------------------------------------*/

//				int reduce = IntStream.range(1, 4) // [1, 2, 3]
//				.reduce(10, Integer::sum);
//				
//				System.out.println(reduce);

		/*--------------------------------------------------------------*/
//				int[] arr = {1,2,3};
//				String[] arrString = {"1","2","3"};
//				
//				
//				// 배열을 이용한 병렬 스트림 생성
//				IntStream parallel = Arrays.stream(arr).parallel();
//				Stream<String> parallelString = Arrays.stream(arrString).parallel();
//				boolean parallel2 = parallel.isParallel();
//				boolean parallel3 = parallelString.isParallel();
//				System.out.println(parallel2);
//				System.out.println(parallel3);

		/*--------------------------------------------------------------*/
//				List<String> testString = new ArrayList<>();
//				
//				testString.add("test1");
//				testString.add("test2");
//				
//				Stream<String> parallelStream = testString.parallelStream();
//				boolean parallel = parallelStream.isParallel();
//				Stream<String> sequential = parallelStream.sequential();
//				boolean parallel2 = sequential.isParallel();
//				System.out.println(parallel2);
		/*--------------------------------------------------------------*/

		List<Product> productList = Arrays.asList(new Product("potatoes", 1000), new Product("orange1", 1500),
				new Product("orange2", 1500), new Product("lemon", 2000), new Product("bread", 2500),
				new Product("sugar", 3000));

		List<String> collectorCollection = productList.stream().map(Product::getItem).collect(Collectors.toList());

//		System.out.println(collectorCollection);

		/*--------------------------------------------------------------*/

		String listToString = productList.stream().map(Product::getItem).collect(Collectors.joining(", ", "<", ">"));

//		System.out.println(listToString);

		/*--------------------------------------------------------------*/

		Integer summingAmount = productList.stream().collect(Collectors.summingInt(Product::getPrice));

//		System.out.println(summingAmount);
		/*--------------------------------------------------------------*/

		IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getPrice));

//		System.out.println(statistics);
		/*--------------------------------------------------------------*/

		Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
				.collect(Collectors.groupingBy(Product::getPrice));

//		System.out.println(collectorMapOfLists);

		/*--------------------------------------------------------------*/

		Map<Boolean, List<Product>> mapPartitioned = productList.stream()
				.collect(Collectors.partitioningBy(el -> el.getPrice() > 1500));

//		System.out.println(mapPartitioned);

		/*--------------------------------------------------------------*/

		Set<Integer> collect = productList.stream()
				.collect(Collectors.collectingAndThen(Collectors.groupingBy(Product::getPrice), Map::keySet));
//		System.out.println(collect);

		/*--------------------------------------------------------------*/
		List<String> list = Arrays.asList("b", "a", "c");

		list.stream().filter(el -> {
			System.out.println("filter() was called.");
			return el.contains("a");
		}).map(el -> {
			System.out.println("map() was called.");
			return el.toUpperCase();
		}).findFirst();

		/*--------------------------------------------------------------*/

		Function<Integer, String> stringMap = el -> String.valueOf(el);

		Stream<Integer> integerStream = Stream.of(1, 2);
		List<String> collectList = integerStream.map(stringMap).collect(Collectors.toList());
		System.out.println("collect = " + collectList);

		/*--------------------------------------------------------------*/
		/*--------------------------------------------------------------*/
		/*--------------------------------------------------------------*/
		/*--------------------------------------------------------------*/

	}

	@Test
	@DisplayName("완주하지 못한 선수")
	void participant() {
		Participant participant = new Participant();

		String[] participants = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };

		String solution = participant.solution(participants, completion);
		System.out.println(solution);

	}

	@Test
	@DisplayName("전화번호 목록")
	void phoneBook() {

		PhoneBook phoneBook = new PhoneBook();

		String[] phone_book = { "119", "97674223", "1195524421" };

		boolean solution = phoneBook.solution(phone_book);
		System.out.println(solution);

	}

	@Test
	@DisplayName("위장")
	void spy() {

		Spy spy = new Spy();

		String[][] clothes1 = { 
				{ "yellowhat", "headgear" },
				{ "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" }
				};
		
		String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		
		String[][] clothes3 = {
				{"a", "A"},
				{"aa", "A"},
				
				{"b", "B"},
				{"ba", "B"},
				{"bb", "B"},
				
				{"c", "C"},
				{"ca", "C"},
				
				{"d", "D"},
				{"da", "D"},
				{"db", "D"}
				};
		String[][] clothes4 = {
				{"a", "A"},
				{"aa", "A"},
				
				{"b", "B"},
				{"ba", "B"},
				{"bb", "B"},
				
				{"c", "C"},
				{"ca", "C"},
				
				{"d", "D"},
				{"da", "D"},
				{"db", "D"},
				
				{"e", "E"},
				{"ea", "E"},
				{"eb", "E"}
		};

		int solution = spy.solution(clothes4);
		System.out.println(solution);

	}

	@Test
	@DisplayName("신규 아이디 추천")
	void newId() {
		
		String input = "...!@BaT#*..y.abcdefghijklm";
		String output = "bat.y.abcdefghi";
		
		NewId newId = new NewId();
		String solution = newId.solution(input);
		
//		Assertions.assertAll("test",
//				() -> assertEquals(output, solution),
//				() -> System.out.println("output : "+output),
//				() -> System.out.println("solution : "+solution)
//		);
		
	}
	
	@Test
	@DisplayName("부가세 공급가액 계산")
	void vatCalc() {
		
		String total = "36000";
		int supply = 0;
		int vat = 0;
		
		double parseDouble = Double.parseDouble(total);
		vat = (int) Math.round((parseDouble/1.1)*0.1);
		
		Integer valueOf = Integer.valueOf(total);
		
		supply = valueOf - vat;
		
		System.out.println("금액 : " + (supply + vat));
		System.out.println("공급가액 : " + supply);
		System.out.println("부가세 : " + vat);
		
		
		
	}
	
	@Test
	@DisplayName("이전달 계산")
	void pastMonth() {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		cal.add(Calendar.MONTH, -1);
		
		String previousMonthfirstDay = (dateFormat.format(cal.getTime())).substring(0, 6) + "01";
		
		
		System.out.println(previousMonthfirstDay);
		
		
	}
	
	
	
	
}
