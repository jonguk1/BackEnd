package day02;
import javax.swing.JOptionPane;
public class MyDemo {

	public static void main(String[] args) {
		String age= JOptionPane.showInputDialog("당신의 나이는?");
		System.out.println("age: " + age);
		
		//유효성 체크(취소, 빈문자열 입력한 경우)
		if(age == null) {
			return;
			//아래 문장을 실행하지 않는다
		}
		// 빈문자열 입력한 경우에도 return시키기
		// if(age == "") {// 주소값 비교
//			System.out.println("나이값을 입력해야 되요");
//			return;
//		}
		//String 참조형 == (주소값 비교)
		//  문자열의 내용 비교 boolean equals(Object o) 메서드를 사용한다
		if(age.equals("")) {//문자열 내용비교를 함
			System.out.println("나이값을 입력해야 되요");
			return;
		}
		
		//Integer.parseInt() : 문자열을 정수로 변환하는 메서드
		int nextAge=Integer.parseInt(age) + 1;
		//1년 뒤에 나이를 출력해보자
		System.out.printf("당신의 내년 나이는 %d세 이겠군요~",nextAge);
		
		
	}

}
