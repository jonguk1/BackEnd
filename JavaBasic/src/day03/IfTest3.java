package day03;
import java.util.Scanner;
//국어 영어 점수를 받아서, 총합계 점수, 평균점수, 학점을 출력하는 프로그램을 작성하세요
		// 평균점수를 이용한 학점
				/* 100 ~90 : A
				 * 89 ~ 80 : B
				 * 79 ~ 70 : C
				 * 69 ~ 60 : D
				 * 그 외: F
				 * 
				 * */
		//성적 테이블표 형태로 출력
				/*-------------------------
				 * 국어		영어
				 * ----------------------
				 * 85.3		92.5
				 * -----------------------
				 * 합계점수: xx 점
				 * 평균점수: 
				 * 학   점: B
				 * -----------------------
				 * */
public class IfTest3 {
	       double x;//인스턴스 변수
	static double y;//클래스 변수(전역변수)
	static boolean z;
	static String str;
	//전역변수, 인스턴스 변수는 초기화하지 않으면 default값이 들어간다
	/* 기본값
	 * byte:0
	 * short:0
	 * char: '\u0000'
	 * int:0
	 * long:0L
	 * float:0.0f
	 * double:0.0
	 * boolean:false
	 * 참조형:null
	 */

	public static void main(String[] args) {
		System.out.println("y: "+y+", z: " + z+", str: "+str);
		Scanner sc =new Scanner(System.in);
		System.out.println("국어 점수=>");
		float kor = sc.nextFloat();
		System.out.println("영어 점수=>");
		float eng = sc.nextFloat();
		
		float sum = (kor+eng);
		float avg = sum/2;
		char grade=' ';//지역변수(local variable)은 초기화하지 않고 사용하면 에러 발생
		
		if(avg>=80 && avg<90) {
			grade='B';
		}else if(avg>=90 && avg<=100) {
			grade='B';
		}else if(avg>=70 && avg<80) {
			grade='C';
		}else if(avg>=60 && avg<70) {
			grade='D';
		}else{
			grade='F';
		}
		
		System.out.println("-------------------------");
		System.out.println("국어\t\t영어");
		System.out.println("-------------------------");
		System.out.println(kor + "\t\t"+eng);
		System.out.println("-------------------------");
		System.out.println("합계점수: " + String.format("%.1f",sum));
		System.out.println("평균점수: " + String.format("%.1f",avg));
		System.out.println("학점:  "+ grade);
		System.out.println("-------------------------");
		
//		if(avg>=90) {
//			System.out.println("학점:  A");
//		}else if(avg>=80) {
//			System.out.println("학점:  B");
//		}else if(avg>=70) {
//			System.out.println("학점:  C");
//		}else if(avg>=60) {
//			System.out.println("학점:  D");
//		}else {
//			System.out.println("학점:  F");
//		}
//		System.out.println("-------------------------");
	}

}
