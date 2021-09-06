package coding_test;

public class IntStack {
	private int max; //스택 용량
	private int ptr; //스택 포인터 : 스택에 쌓여 있는 데이터 수
	private int[] stk; //스택의 본체
	
	
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int push(int x) throws OverflowIntStackException{
		/*
		 * max와 ptr이 동일하면 이미 overflow 상태임, 일치하는지 여부(==)로 판단할 수도 있지만 관계 연산자(>=)로 판단하여
		 * ptr이 상한과 하한을 벗어나서 접근하는 것을 막을 수 있다.
		 */
		if(ptr >= max) { 
			throw new OverflowIntStackException();
		}
		
		return stk[ptr++] = x;
		
	}
	
	public int pop() throws EmptyIntStackException{
		
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		
		return stk[--ptr]; 
	}
	
	public int peek() throws EmptyIntStackException{
		
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		
		return stk[ptr -1];
	}
	
	public int indexOf(int x) {
		
		for(int index = ptr-1; index >= 0; index--) {
			if(stk[index] == x) {
				return index;
			}
		}
		
		return -1;
	}
	
	public void clear() {
		ptr = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public boolean isFull() {
		return ptr >= max;
	}
	
	public void dump() {
		if(ptr ==0) {
			System.out.println("스택이 비어 있습니다.");
		}else {
			for(int value : stk) {
				System.out.println(value);
			}
		}
	}
	
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {
			
		}
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {
			
		}
	}
}

