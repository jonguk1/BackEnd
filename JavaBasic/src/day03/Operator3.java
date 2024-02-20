package day03;

public class Operator3 {
	
	public static void main(String[] args) {
		System.out.println("--연산후 대입연산자(+=, -=, *=, /=, %=)----");
		int i = 5;
		i +=3;
		System.out.println("i:" +i);
		i -=2;
		System.out.println("i:" +i);
		i *=8;
		System.out.println("i:" +i);
		i /=5;
		System.out.println("i:" +i);
		i %=5;
		System.out.println("i:" +i);
		
		//연산자 우선순위
		//산술 > 비교 > 논리 > 대입
		//단항 > 이항 > 삼항
		//곱셈,나눗셈> 더하기,빼기
		// -x+3 : 단항 >이항
		// x+3 > y-2 : 산술 > 비교
		// x>3 & y<5 : 비교 > 논리
		//논리연산자에서는 &,&& > |,||
	}

}
