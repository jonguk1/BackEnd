package day04;

import java.util.Scanner;

/*n!
1! : 1
2! : (1)x 2
3! : (1x2)x3 ====>6
4! : (1x2x3)x4 ====>24
5! : (1x2x3x4)x5 ===> 120
n! : (n-1)!xn
여기서 1!=1 그리고 n!=nx(n-1)! 라는 팩토리얼 성질을 이용해서 프로그램을 만들어보자
 * */
public class Factorial {

	public static int factorial(int num) {
		//종료 조건
		
		//재귀 단계
	}
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("팩토리얼 연산을 수행합니다. 정수를 입력하세요: ");
		int n =sc.nextInt();
		int result=factorial(n);
		System.out.println(result);

	}

}
