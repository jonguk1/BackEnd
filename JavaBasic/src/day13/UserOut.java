package day13;

public class UserOut extends Thread{
	
	private Account account;

	public UserOut(String name, Account ac) {
		this.setName(name);
		this.account=ac;
	}

	@Override
	public void run() {
		
		for(int i=0;i<5;i++) {
			int val=(int)(Math.random()*5+1);
			account.get(val);//1~5만원 사이를 랜덤하게 인출
		}
		
	}
}
