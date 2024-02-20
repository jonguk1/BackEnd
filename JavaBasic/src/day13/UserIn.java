package day13;

public class UserIn extends Thread{

	private Account account;
	
	public UserIn(String name, Account ac) {
		this.setName(name);//스레드 이름 주기
		this.account=ac;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<5;i++) {
			account.save(1);//1만원씩 저축
		}
		
	}

}
