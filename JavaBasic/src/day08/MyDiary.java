package day08;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;

import day09.MyDiarySubFrame;
import day09.NotSupportNameException;

public class MyDiary extends JFrame{
	
	Container cp;
	
	String[] userInfo = {"root","123"};//아이디, 비밀번호
	private JTextField textField;
	private JPasswordField passwordField;

	public MyDiary() {
		super(":::MyDiary v1.1:::");
		cp= this.getContentPane();//컨텐트 페인
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/title.PNG")));
		lblNewLabel.setBounds(12, 42, 363, 207);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.BOLD, 18));
		textField.setBounds(55, 288, 292, 64);
		panel.add(textField);
		textField.setColumns(10);
		textField.setBorder(new TitledBorder("아이디"));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.BOLD, 18));
		passwordField.setBounds(55, 377, 292, 64);
		panel.add(passwordField);
		passwordField.setBorder(new TitledBorder("비밀번호"));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//아이디 ,비번 입력값 얻기
				String id = textField.getText();
				char[] password = passwordField.getPassword();
				String pw = new String(password);
				//유효성 체크
				if(id ==null || pw== null|| id.equals("")||pw.equals("")) {
					showMsg(panel, "아이디,비밀번호를 입력하세요");
					return;
				}
				try {
					boolean isOk = loginChack(id, pw);
					
					String result = (isOk)? id+"님 환영합니다. 일기장으로 이동합니다":"아이다 또는 비밀번호가 일치하지 않아요";
					showMsg(panel, result);
					if(isOk) {
						MyDiary.this.setVisible(false);
						
						MyDiarySubFrame sub = new MyDiarySubFrame();
						sub.setSize(400,700);
						sub.setVisible(true);
					}
				}catch(NotSupportNameException ex) {
					showMsg(panel, ex.getMessage());
				}
			}
			
		});
		btnNewButton.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/로그인.PNG")));
		btnNewButton.setBounds(58, 469, 289, 54);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset처리
				textField.setText("");
				passwordField.setText("");
				//입력 포커스 주기
				textField.requestFocus();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/reset.PNG")));
		btnNewButton_1.setBounds(58, 542, 289, 54);
		panel.add(btnNewButton_1);
		
		//창닫기 처리
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//System.exit(0)와 동일
	}
	
	public void showMsg(JPanel p,String msg) {
		JOptionPane.showMessageDialog(p, msg);
	}
	
	
	public boolean loginChack(String id, String pw) throws NotSupportNameException{
		if(id.equalsIgnoreCase("killer")) {
			throw new NotSupportNameException("킬러로 절대 접속 불가");
		}
		
		if(id.equals(userInfo[0]) && pw.equals(userInfo[1])) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyDiary my = new MyDiary();
		my.setSize(400,700);
		my.setVisible(true);

	}
}
