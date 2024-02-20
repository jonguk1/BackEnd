package day03;
import java.util.Scanner;
public class ScannerTest {

	public static void main(String[] args) throws Exception {
		System.out.println("정수를 입력하세요=>");
		//int n= System.in.read();
		//System.out.println("n: " + n);
		Scanner sc = new Scanner(System.in);
		//java.util.Scanner클래스
		int n = sc.nextInt();
		System.out.println("n: " +n);
		
		System.out.println("키를 입력=>");//185.3
		double height = sc.nextDouble();
		System.out.println("당신의 키는" + height);
		
		System.out.println("아침은 먹었는지 입력(true/false)=>");
		boolean food =sc.nextBoolean();
		System.out.println("아침식사 여부: " + food);
		
		System.out.println("올해의 목표는=>");
		String goal = sc.next();
		System.out.println("당신의 목표:" + goal);
		
		System.out.println("올해의 목표를 문장으로 작성=>");
		//엔터값 건너뛰기
		sc.skip("\r\n");//엔터(\r\n)
		String goal2 = sc.nextLine();//라인단위로 입력받음
		// \n(줄바꿈) 직전까지는 문자열을 반환함
		System.out.println("당신의 목표:" + goal2);
	}

}
