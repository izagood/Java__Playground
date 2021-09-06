package coding_test;

public class RecurObject {
	
	
	public void recur(int num) {
		IntStack stack = new IntStack(num);
		
		while(true) {
			if(num > 0) {
				stack.push(num);
				num = num - 1;
				continue;
			}
			
			if(stack.isEmpty() != true) {
				num = stack.pop();
				System.out.println(num);
				num = num - 2;
				continue;
			}
			
			break;
		}
	}
}
