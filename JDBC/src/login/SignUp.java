package login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class SignUp extends JFrame{
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField telTextField;
	private JPasswordField pwdField;

	public SignUp(){
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		idTextField = new JTextField();
		idTextField.setBounds(125, 130, 229, 53);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(125, 280, 229, 53);
		panel.add(nameTextField);
		
		telTextField = new JTextField();
		telTextField.setColumns(10);
		telTextField.setBounds(125, 361, 229, 53);
		panel.add(telTextField);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 130, 101, 53);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(12, 203, 101, 53);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(12, 280, 101, 53);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TEL");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_3.setBounds(12, 361, 101, 53);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("회원가입완료");
		btnNewButton.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				char[] password = pwdField.getPassword();
				String pwd = new String(password);
				String name = nameTextField.getText();
				String tel = telTextField.getText();
				
				if(id == null || id.equals("")) {
					showMsg(panel, "아이디를 입력해주세요");
					idTextField.requestFocus();
					return;
				}else if(pwd == null || pwd.equals("")) {
					showMsg(panel, "패스워드를 입력해주세요");
					pwdField.requestFocus();
					return;
				}else if(name == null || name.equals("")) {
					showMsg(panel, "이름를 입력해주세요");
					nameTextField.requestFocus();
					return;
				}else if(tel == null || tel.equals("")) {
					showMsg(panel, "전화번호를 입력해주세요");
					telTextField.requestFocus();
					return;
				}
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user="scott",pw="tiger";
					
					Connection con = DriverManager.getConnection(url,user,pw);
					
					String sql = "INSERT INTO java_member(id,pw,name,tel,indate) VALUES(?,?,?,?,sysdate)";
					
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, pw);
					pstmt.setString(3, name);
					pstmt.setString(4, tel);
					
				    showMsg(panel, name + "님의 회원가입이 완료되었습니다");
				    
				    pstmt.close();
				    con.close();
				    
				    idTextField.setText("");
				    nameTextField.setText("");
				    telTextField.setText("");
				    pwdField.setText("");
				    
				}catch (Exception ex) {
					showMsg(panel, ex.getMessage());
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton.setBounds(46, 448, 297, 53);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원탈퇴처리");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				String name = nameTextField.getText();
				
				if(id == null || id.equals("")) {
					showMsg(panel, "아이디를 입력해주세요");
					idTextField.requestFocus();
					return;
				}
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user="scott",pw="tiger";
					
					Connection con = DriverManager.getConnection(url,user,pw);
					
					String sql = "DELETE FROM java_member WHERE id =?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);

				    showMsg(panel, name + "님의 삭제가 완료되었습니다");
				    
				    pstmt.close();
				    con.close();
				    
				    idTextField.setText("");
				    
				}catch (Exception ex) {
					showMsg(panel, ex.getMessage());
				}
				
				
			}
				
		});
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton_1.setBounds(46, 509, 297, 53);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("모든회원목록");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberList member = new MemberList();
				member.setSize(400,700);
				member.setVisible(true);
				
			}
		});
		btnNewButton_2.setBackground(new Color(128, 128, 255));
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton_2.setBounds(46, 572, 297, 53);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SignUp.class.getResource("/login/google.jpg")));
		lblNewLabel_4.setBounds(83, 21, 203, 84);
		panel.add(lblNewLabel_4);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(125, 207, 229, 49);
		panel.add(pwdField);
		
	}
	
	public void showMsg(JPanel p,String msg) {
		JOptionPane.showMessageDialog(p, msg);
	}
	
	public static void main(String[] args) {
		SignUp signUp = new SignUp();
		signUp.setSize(400,700);
		signUp.setVisible(true);

	}
}
