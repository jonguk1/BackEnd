package day07;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyCalc extends JFrame{

	Container cp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	//기본생성자 구성하기
	public MyCalc() {
		cp = this.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MyCalc.class.getResource("/day07/calc.PNG")));
		lblNewLabel.setBounds(12, 10, 462, 177);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("숫자1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(64, 0, 64));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_1.setBounds(12, 218, 129, 61);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("숫자2");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(64, 0, 64));
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(12, 278, 129, 61);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(150, 229, 268, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 289, 268, 45);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("더하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(textField, "더하기 버튼을 눌렀군요");
				//숫자1 입력박스에 입력한 값 가져오기
				String str1 = textField.getText();
				//숫자2 입력박스에 입력한 값 가져오기
				String str2 = textField_1.getText();
				setTitle("숫자1: " + str1 +" 숫자2: " + str2);
				
				try {
					//숫자1+숫자2 더한 값을 결과 입력박스에 넣어준다
					int result = Integer.parseInt(str1) + Integer.parseInt(str2);
					textField_2.setText(result+ "");
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnNewButton, "정수를 입력해야 해요!!");
				}

			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 24));
		btnNewButton.setBounds(67, 426, 159, 81);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("지우기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				//입력 포커스 주기
				textField.requestFocus();
				setTitle("");
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 24));
		btnNewButton_1.setBounds(259, 426, 159, 81);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("결 과");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(64, 0, 64));
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(12, 344, 129, 61);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 355, 268, 45);
		panel.add(textField_2);
	}//기본생성자----------
	
	public static void main(String[] args) {
		
		MyCalc my = new MyCalc();
		my.setSize(500,600);
		my.setVisible(true);
		

	}
}
