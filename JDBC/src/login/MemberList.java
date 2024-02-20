package login;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MemberList extends JFrame{

	public MemberList() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 44, 300, 550);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("굴림", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user="scott",pw="tiger";
			Connection con = DriverManager.getConnection(url,user,pw);
			
			String sql = "SELECT id,name,tel,indate FROM java_member";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			     String id = rs.getString("id");
			     String name = rs.getString("name");
			     String tel = rs.getString("tel");
			     Date indate = rs.getDate("indate");
			     
			     textArea.append("아이디: "+ id + "\n");
			     textArea.append("이름: "+ name + "\n");
			     textArea.append("전화번호: "+ tel + "\n");
			     textArea.append("날짜: "+ indate + "\n");
			     textArea.append("\n");
			}
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(panel, ex.getMessage());
		}
		
	}
	
}
