package quiz01;
import javax.swing.JOptionPane;

public class Exam03 {

	public static void main(String[] args) {
		String telecom = JOptionPane.showInputDialog("통신사는?");
		String phoneNumber = JOptionPane.showInputDialog("전화번호는?");
		String name = JOptionPane.showInputDialog("이름은?");
		
		System.out.println(name + "님은 " + telecom + "에 " + phoneNumber
				+ "로 가입되셨습니다");

	}

}
