package day02;

public class Primitive3 {
	
	//main
	public static void main(String[] args) {
		System.out.println("3. 문자형(char)----------------------");
		//char(2byte, 0~65535) : 자바는 유니코드 체계를 사용(모든 국가 언어 표현 가능)
		char 변수1='가';
		char 家= '가';
		System.out.println(변수1);
		System.out.println(家);
		
		char c1= '최';
		char c2= '\uff57';
		System.out.println(c1);
		System.out.println(c2);
		char c3='A';//65
		System.out.println(c3);
		System.out.println(c3+1);
		//char + int ==> 큰 자료형으로 자동 형번환(promotion, upcasting)
		//c3+1==>int==> char유형으로 변환하려면 강제 형변환(casting,downccasting)
		System.out.println((char)(c3 + 1));
		//char타입이 연산에 사용되면 자동으로 int형변환한다
		//char + char => int
		
		String str="최길동";//문자열 ==> Reference Type(참조형)
		System.out.printf("str=%s\n",str);
		
		System.out.println("4. 논리형 (boolean) -------------");
		//boolean (1byte) : true,false값만 갖는다
		boolean bool=true;
		boolean bool2 = 2>5;
		System.out.println("bool=" + bool);
		System.out.println("bool2=" + bool2);
	}//-----------------------------------

}///////////////////////////////////
