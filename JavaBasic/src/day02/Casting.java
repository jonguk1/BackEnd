package day02;

public class Casting {

	public static void main(String[] args) {
		// 형변환
		//[1] 자동형변환
		//[2] 강제형변환==>형변환 연산자를 사용==> (자료형)변수
		//byte < short < int  < long < float < double
		//	     char
		
		byte b=10;
		float f=b;//byte타입==> float으로 자동 형변환
		System.out.println(b);
		System.out.println(f);

		double d=123.456;
		
		short s=(short)d;//강제형변환(casting): 데이터 손실이 발생할 수 있다
		System.out.println(d);
		System.out.println(s);
		
		int x=68;
		char y=(char)x;
		//형변환한뒤 x,y값 출력하기
		System.out.printf("x=%d%n", x);
		System.out.printf("y=%c%n", y);
		
		double result = b + y *f; //promotion
		//byte+char+float
		System.out.println(result);
		byte m=1;
		byte n=5;
		//byte result2=m+n; [x]
		int result2=m+n;
		System.out.println(result2);
		/* int형보다 작은 유형의 데이터가 연산에 사용되면 자동으로 int유형으로 형변환 된다
		 * 
		 * byte----+
		 * short---+---int
		 * char----+
		 * */
		char c1='A';
		char c2='B';
		int c3=c1+c2;
		String c4=""+c1+c2;
		System.out.println(c3);//131
		System.out.println(c4);//AB

	}

}
