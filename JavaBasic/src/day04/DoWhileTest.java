package day04;

public class DoWhileTest {

	public static void main(String[] args) throws Exception{
		/** 
		 * 변수 선언문 및 초기화식
		 * do{
		 *   실행문
		 *   증감식
		 * }while(조건식);
		 * 
		 * while문의 경우 조건 체크를 먼저 함
		 * do ~ while문의 경우 실행문을 먼저 실행한 뒤 조건 체크를 함
		 * */
		//Hello문자열을 5번 출력하세요
		int i =1;
		do {
			System.out.println("Hello " + i);
			i++;
		}while(i <6);
		System.out.println("The End ~~~~~" + i);
		
		int num = 0;
		do {
			System.out.println("0 ~ 9 사이의 정수값을 입력하세요 [종료: x]");
			num = System.in.read();
			//엔터(\r\n)값 건너뛰기
			System.in.skip(2);//2byte 건너뜀
			
			System.out.println("num: " + num);
		}while(num != 'x');
		
	}

}
