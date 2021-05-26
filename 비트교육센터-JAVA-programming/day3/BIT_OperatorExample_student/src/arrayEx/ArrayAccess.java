package arrayEx;
import java.util.Scanner;

public class ArrayAccess {
	public static void main(String[] args) {
/* <배열 생성 1>
   int intArray[] = new int[2];
   intArray[0] = 15;
   intArray[1] = 3;
   
   <배열 생성 2>
   int intArray[] = {15, 3};   		 		
 */
		
		Scanner scanner = new Scanner(System.in);
		int intArray[] = new int[5]; // 배열 생성
		int max=0; 		
		System.out.println("양수 5개를 입력하세요.");		
		for(int i=0; i<5; i++) {
			intArray[i] = scanner.nextInt(); // 입력받은 정수를 배열에 저장
			if(intArray[i] >max) // intArray[i]가 현재 가장 큰 수보다 크면
				max = intArray[i]; // intArray[i]를 max로 변경
		}
		System.out.print("가장 큰 수는 " + max + "입니다.");

	}
}