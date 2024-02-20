package day03;
import java.util.Scanner;
/*switch문에 들어갈 수 있는 자료형
 * 	[1] int형 이하 (byte,short,char,int) [o] long형은 안됨[x]
 *  [2] String형도 가능
 * 
 *   switch(변수 or 수식){
 *   	case 값1: 실행문; break;
 *   	case 값2: 실행문; break;
 *   	case 값3: 실행문; break;
 *   	default: 실행문;
 *   }
 * 
 * */
public class SwitchTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수강하는 과목 입력=>");
		String subject = sc.next();
		//자바 => 1103호로 가세요
		//파이썬 => 1102호로 가세요
		//리눅스 => 1104호로 가세요
		//카운터에서 문의하세요
		
		switch (subject) {
		case "자바":
			System.out.println("1103호로 가세요");
			break;
		case "파이썬":
			System.out.println("1102호로 가세요");
			break;
		case "리눅스":
			System.out.println("1104호로 가세요");
			break;
		default:
			System.out.println("카운터에서 문의하세요");
			break;
		}

	}

}
