package day02;
//import java.lang.System;//java.lang패키지는 import문은 생략해도 된다 => 자동으로 import형
import java.util.Date;

public class Primitive {

	//main()
	public static void main(String[] args) {
		System.out.println("----기본 자료형(Primitive Type)-------");
		Date d = new Date();
		System.out.println("오늘 날짜: " + d);
		System.out.println("1. 정수형 (byte < short < [int] < long)"
				+ "--------------");
		//자료형 변수명 = 값(literal)
		byte bt1 = -128; // 1byte (-128 ~ 127)
		byte bt2 = 127;
		System.out.println("bt1= " + bt1);
		//sysout  Ctr + 스페이스바
		System.out.println("bt2= " + bt2);
		//3000
		short st1 = 3000;//2byte -2^15 ~ 2^15-1
		short st2 = -5500;
		
		System.out.println("st1= " + st1);
		System.out.println("st2= " + st2);
		
		int it = 500000;//4byte(32bit) -2^31 ~ 2^31-1
		//int =>정수형의 default
		long ln1 =80;
		long ln2 =80L;// 뒤에 접미사 L,l을 붙인다
		System.out.println("it=" + it);
		System.out.println("ln1=" + ln1);
		System.out.println("ln2=" + ln2);
		
		int i =1000000000; //0이 9개 int형 -2147483648 ~ 2147483647
		long j =10000000000L; // 0이 10개
		
		//printf(포맷문자열,값,....)
		// %d : 정수값
		// %f : 실수값
		// %s : 문자열
		// %n : 줄바꿈(new line)
		// \n : 줄바꿈
		System.out.printf("i=%d%n", i);
		System.out.printf("j=%d\n", j);
		
		int a=010;//8진수 정수, 앞에 '0'을 접두어로 붙인다
		int b=011;
		
		System.out.printf("a=%d%n", a);
		//Ctrl + Alt + ↓
		System.out.printf("b=%d%n", b);
		
		int c= 0217;//143
		System.out.printf("c=%d%n", c);
		//동일한 스코프 내에 동일한 변수를 선언할 수 없다
		int d1 = 0x1A;//16진수 정수, 앞에 0x를 접두어로 붙인다
					  //0 ~ 15 ==> 0 ~ 9,a,b,c,d,e,f
		//1*16 + 10 =>26
		System.out.println("d1=" + d1);//26
		int d2= 0x1AF;
		//1" 16^2 + 10*16^1 + 15
		System.out.println("d2=" + d2);//431
		
		
	}
}
