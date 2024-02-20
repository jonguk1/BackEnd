package day03;
import java.util.Scanner;
public class SwitchTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사번을 입력하세요 [예 A100EX] =>");
		String no = sc.next();
		System.out.println("no: " + no);
		
		//A : 기획부 사원이며 사원의 고유번호는 100EX입니다
		//B : 총무부 사원이며 사원의 고유번호는 100EX입니다
		//C : 개발부 사원이며 사원의 고유번호는 100EX입니다
		// 나머지: 해당부서 없음
		
		char ch = no.charAt(0);
		System.out.println("부서코드: " + ch);
		//String 클래스의 메서드
	    /* char chartAt(int index) : index위치의 문자 1개를 추출해서 반환
		* String substring(int start, int end)
	    * : index번소 start위치에서 시작해서 end-1까지의 문자열을 추출해서 반환
		* */
		
		String str = no.substring(1,6);
		
		switch (ch) {
		case 'A':
			System.out.println("기획부 사원이며 사원의 고유번호는 " + str + "입니다");
			break;
		case 'B':
			System.out.println("총무부 사원이며 사원의 고유번호는 " + str + "입니다");
			break;
		case 'C':
			System.out.println("개발부 사원이며 사원의 고유번호는 " + str + "입니다");
			break;
		default:
			System.out.println("해당부서 없음");
			break;
		}

	}

}
