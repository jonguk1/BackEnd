package day03;

public class ForTest {

	public static void main(String[] args) {
		/*
		 * for(변수선언및 초기화;조건식;증감식){
		 *     실행문;
		 * }
		 * 조건식이 true면 실행문을 반복 실행
		 * 
		 * for(;;){//=>무한루프
		 * 
		 *}
		 * */
//		for(;;) {
//			System.out.println("@@@@");
//		}
		for(int i=0;i<10;i++) {//지역변수 i의 scope는 for블럭까지이다
			System.out.println(i + ": *");
		}//for----
		System.out.println("############");
		
		for(int i = 10;i>0;i-=3) {
			System.out.println("Hello: " + i);
		}
		int j =2;//j의 scope는? ==> main()블럭까지
		for(;j<20;j*=3) {
			System.out.println("Java: "+j);
		}
		System.out.println("@@@@@@@@@@ " + j);

	}//main()

}//////////////
