package day02;

public class Primitive2 {

	//main
	//static,public => modifier(제한자, 지정자, 한정자)
	//void => 반환값이 없다는 의미
	//main => 메서드명, 동사형, 소문자로 시작, camel표기법
	//String[] => String 타입의 배열 
	//args => 매개변수(parameter, argument)
	public static void main(String[] args) {
		System.out.println("2. 실수형(float, double) ----------------");
		// float(4byte) < [double] (8byte)
		float ft1=10.123F;
		//float의 경우 부동소수점일 경우 반드시 뒤에 접미사 f,F를 붙여준다
		//Ctrl + D : 현재 커서 한줄을 삭제
		System.out.printf("ft1=%f%n", ft1);
		System.out.printf("ft1=%.3f%n", ft1);//소수점 이하 3자리까지만 출력
		
		float ft2= 55;//int 값을 float타입 변수에 대입 
		              //==>promotion(자동형변환) : 큰자료유형으로 자동 형변환
		System.out.println("ft2=" + ft2);
		
		float ft3= 'A';//char => float A의 ascil코드값 65
		System.out.println("ft3=" + ft3);//65.0
		
		float ft4 = .879f;//0.879f
		System.out.println("ft4=" + ft4);
		
		//double (8byte) : 소수점 이하 15자리 내외
		double db1 = -741.258;
		double db2 = 4545.001D;
		System.out.println("db1=" + db1);
		System.out.println("db2=" + db2);
		
		//과학적 지수 표기방법:E, e
		double db3= 8E-2;//8*10^-2
		double db4= 8E+3;//8*10^3
		System.out.println("db3=" + db3);
		System.out.println("db4=" + db4);
		
		float ft5 = 900e-7F;
		System.out.println("ft5="+ft5);
		
	}//main()---------------
}//class///////////////////////////////////
