package day13;

public class Account {
	
	private int money=10;
	private boolean flag=false;
	//동기화 블럭. Account객체의 lock을 소유한 스레드만이 동기화 블럭을 수행할 수 있다.
	//			 동기화 블럭을 벗어나면 수행하던 스레드는 락을 반납한다
	public void save(int val) {
		synchronized (this) {
			money+=val;
			System.out.printf("입금액: %d, 입금후 잔액: %d%n", val, money);		
		}
	
	}//save()-----------------
	synchronized public void get(int val) {
		if(money-val<0) {
			System.out.printf("현금 부족!! 현재 잔액: %d, 요청 금액: %d%n", money, val);
			return;
		}
		money-=val;
		System.out.printf("출금액: %d, 출금후 잔액: %d%n", val, money);
		
	}//get()----------------

}/////////////////////////////