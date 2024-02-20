package quiz01;
import javax.swing.JOptionPane;

public class Exam02 {

	public static void main(String[] args) {
		String height = JOptionPane.showInputDialog("키는?");
		
		double normalWeight = (Double.parseDouble(height)-100) * 0.9;
		
		System.out.println("적정몸무게: " + normalWeight);
		
	}

}
