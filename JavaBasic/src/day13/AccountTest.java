package day13;

public class AccountTest {

	public static void main(String[] args) {
		
		Account ac= new Account();
	    //인출, 저축 스레드가 ac를 공유하자
		UserIn u1 = new UserIn("개미", ac);
		UserOut u2 = new UserOut("베짱이", ac);
		
		u2.start();
		u1.start();
		
		
	}
}
