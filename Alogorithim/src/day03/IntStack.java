package day03;
/*#  큐와 스택
1. 큐 - Queue : Fisrt In First Out 구조
    ex) 택시 줄서기 : 가장 먼저 줄 선 사람이 먼저 택시를 탄다.
    - 큐에서 데이터를 한 개 집어넣는 동작을 인큐(enqueue),
      큐 안에 있는 데이터를 한 개 꺼내는 동작을 디큐(dequeue)라고 표현한다.
2. 스택- Stack : Last In First Out
    ex) 접시 쌓기 :  접시를 쌓아 올리면, 꺼낼 때 가장 마지막 접시부터 꺼내게 됨
    - 스택에 데이터 하나 넣는 동작을 push,
      스택에 있는 데이터를 하나 꺼내는 동작을 pop라고 표현한다.
 * */
public class IntStack {
	private int capacity;//용량
	private int ptr;//배열에 인덱스로 사용되는 포인터. push()할때는 증가, pop()할때는 감소
	private int [] stk;//정수값을 저장할 배열
	
	public IntStack(int capa) {
		this.capacity=capa;
		ptr=0;
		stk=new int[this.capacity];
	}
	//스택에 저장되어 있는 데이터수를 변환
	public int size() {
		return ptr;
	}
	/**데이터를 삽입하는 메서드, 스택(배열)이 가득 차면 예외 발생 */
	public int push(int val) {
		if(ptr>=capacity) throw new RuntimeException("OverflowException");
		return stk[ptr++]=val;//push한 값을 반환하고 포인터값을 증가시킨다
	}
	/**스택에 꼭대기(top)에 있는 데이터를 반환 */
	public int pop() {
		if(ptr<=0) throw new RuntimeException("EmptyException");
		return stk[--ptr];
	}
	
	/**스택 꼭대기에 있는 데이터를 반환하는 메서드. 삭제하는 개념이 아님*/
	public int peek() {
		if(ptr<=0) throw new RuntimeException("EmptyException");
		return stk[ptr-1];
	}
	
	/**스택이 비어있는지 여부를 판단하는 메서드*/
	public boolean empty() {
		return ptr<=0;
	}
	
	/**스택이 가득 찼는지 여부를 판단하는 메서드*/
	public boolean full() {
		return ptr>=capacity;
	}
	
	/** 스택에 모든 데이터 비우기*/
	public void clear() {
		ptr=0;
	}
	/**스택에 저장된 요소값들을 출력하는 메서드
	 * LIFO
	 * 스택의 위 ==> 아래 방향의 데이터를 출력
	 * */
	public void printStack() {
		for(int i=0;i<ptr;i++) {
			System.out.println(stk[ptr-i-1]);
		}
	}
	/**데이터를 검색하여 데이터가 있는 곳의 인덱스 번호를 반환*/
	public int search(int val) {
		for(int i=ptr-1;i>=0;i--) {
			if(stk[i]==val) {
				return i;
			}
		}
		return -1;
	}
	
}
