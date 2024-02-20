package day08;
//try-catch로 예외처리하되 for루프 안쪽에서
public class ExceptionTest3 {

	public static void main(String[] args) {
		
		for(int i=0;i<=5;i++) {
			try {
				int y=50/(i-3);
				System.out.println("y: "+ y);
			}catch(ArithmeticException e) {
				System.out.println("0입니다");
			}
		}//for--
		
		System.out.println("---The End------------");

	}

}
