package day04;

public class WhileTest {

	public static void main(String[] args) {
		/* 변수 선언문 및 초회식
		 * while(조건문){
		 *    실행문
		 *    증감식
		 * }
		 * 
		 * 조건식이 true면 실행문을 실행 (계속 반복)
		 *       false면 반복문을 벗어남
		 * 
		 */
		
		int now = 0;
		while(now < 11) {
			System.out.println("오전 시간입니다 " + now);
			now++;
		}
		System.out.println("now: " + now);
		
		int now2 = 7;
		while(now2 > 0) {
			System.out.println("오후 시간입니다~ " + now2);
			now2 -=3;
		}
		
		while(true) {
			System.out.println("무한 루프 돕니다~@@@@");
		}
	

	}

}
