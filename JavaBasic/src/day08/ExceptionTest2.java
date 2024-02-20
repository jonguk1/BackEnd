package day08;
//try-catch로 예외처리하되 for루프 바깥쪽에서
public class ExceptionTest2 {

	public static void main(String[] args) {
		
		try {
			for(int i=0;i<=5;i++) {
				int y=50/(i-3);
				System.out.println("y: "+ y);
			}//for--
		}catch(ArithmeticException e) {
			System.out.println("0입니다");
		}
		
		System.out.println("---The End------------");

	}

}
