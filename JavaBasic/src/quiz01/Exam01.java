package quiz01;
import javax.swing.JOptionPane;
//Exam01 ~ Exam04
//quiz01_홓길동.zip제출
public class Exam01 {

	public static void main(String[] args) {
		String width = JOptionPane.showInputDialog("가로길이는?");
		String height = JOptionPane.showInputDialog("세로길이는?");
		
		int area = Integer.parseInt(width) * Integer.parseInt(height);
		
		System.out.println("사각형 면적: " + area);
		

	}

}
