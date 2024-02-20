package day03;
import java.sql.*;
import java.util.*;
/*
 * PreparedStatement를 이용하여 
 * java_member테이블의 회원정보를 수정해 봅시다
 * 
 * */
public class PreparedStatementTest {

	public static void main(String[] args) 
	throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 회원의 ID를 입력: ");
		String id = sc.nextLine();
		
		System.out.println("수정할 회원의 Name 입력: ");
		String name = sc.nextLine();
		
		System.out.println("수정할 회원의 Tel 입력: ");
		String tel = sc.nextLine();
		
		System.out.println("수정할 회원의 PW 입력: ");
		String pw = sc.nextLine();
		
		System.out.println(id + "/" + name + "/" + tel+ "/" + pw);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott",pwd="tiger";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("DB Connected...");
		
		String sql = "UPDATE java_member SET name =?, tel =? ,pw=? WHERE id=?";
		
		//4.PreparedStatement객체 얻기
		//Connection의 prepareStatement(쿼리문) 메서드를 이용
		
		//?를 제외한 sql문을 전처리 시켜둔다
		PreparedStatement pstm = con.prepareStatement(sql);
		
		//5.실행시키기 전에 ?에 해당하는 값 설정
		pstm.setString(1, name);
		pstm.setString(2, tel);
		pstm.setString(3, pw);
		pstm.setString(4, id);
		
		//6.쿼리문 실행
		int cnt = pstm.executeUpdate();
		System.out.println(cnt + "개의 레코드 수정 완료");
		
		//jdbc의 Connection은 auto commit
		
		//7.db자원 반납
		pstm.close();
		con.close();

	}

}
