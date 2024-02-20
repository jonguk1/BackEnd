package day03;
import java.util.Scanner;

public class IfTest {
	/*
	 * if(조건식){
	 * 		실행문;
	 * }
	 * 실행문2;
	 * 조건식이 true면 실행문을 실행
	 * -------------------------
	 * if(조건식){
	 *     실행문1;
	 * }else{
	 *     실행문2;
	 * }
	 */

	public static void main(String[] args) {
		System.out.println("정수를 입력하세요 =>");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("입력값: " + num);
		if(num >0) {
			System.out.printf("%d는 양수입니다~\n",num);
		}
		System.out.println("*******************");
		
		//[문제1] 입력받은 값이 짝수면 "Even"을 출력하고, 홀수면 "Odd"를 출력하세요
		
		if(num % 2 == 0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
		
		String res = (num % 2 == 1)? "Odd(홀수)":"Even(짝수)";
		System.out.println(res);
		
	}

}
