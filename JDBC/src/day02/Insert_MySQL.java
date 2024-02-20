package day02;
import java.sql.*;
import java.util.*;
/*mysql의 mydb에 연결해서
 * java_member테이블에 회원정보를 insert하세요
 * */

public class Insert_MySQL {

	public static void main(String[] args) 
	throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디: ");
		String id = sc.nextLine();
		
		System.out.println("비밀번호: ");
		String pw = sc.nextLine(); 
		
		System.out.println("이름: ");
		String name = sc.nextLine(); 
		
		System.out.println("전화번호: ");
		String tel = sc.nextLine(); 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 로딩 성공!");
		
		String url="jdbc:mysql://localhost:3306/mydb?userUnicode=true&serverTimezone=Asia/Seoul";
		String user="root",pwd="1234";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("MySQL 연결 성공");
		
		String sql = "INSERT INTO java_member(id,pw,name,tel,indate)";
		       sql+= " VALUES('"+id+"', '"+pw+"', '"+name+"', '"+tel+"',curdate())";//now()
		       
		System.out.println(sql);
		
		//DML문장(INSERT,UPDATE,DELETE)을 실행시킬때
		//public int executeUpdate(String sql)를 사용하는 것이 좋다
		//==> sql문장에 의해 영향받은 레코드 개수를 반환한다
		
	    Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt+ "개의 레코드를 삽입했습니다");
		//		boolean b = stmt.execute(sql);
		//		System.out.println("b: " + b);
		
		stmt.close();
		con.close();

	}

}
