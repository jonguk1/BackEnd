package day03;
import java.sql.*;
import java.util.*;
//실습 DEPT테이블에 부서정보를 입력받아 INSERT하는 문장을 실행시키세요
//부서번호, 부서명, 근무지 =>
public class PreparedStatementTest2 {

	public static void main(String[] args) 
	throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("부서번호를 입력하세요");
		String deptNo = sc.nextLine();
		
		System.out.println("부서명를 입력하세요");
		String dname = sc.nextLine();
		
		System.out.println("근무지를 입력하세요");
		String loc = sc.nextLine();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user= "scott",pwd="tiger";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		
		String sql = "INSERT INTO DEPT(deptno, dname,loc) VALUES(?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, deptNo);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt +"개의 레코드를 등록하셨습니다");
		
		pstmt.close();
		con.close();

	}

}
