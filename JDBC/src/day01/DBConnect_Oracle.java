package day01;
import java.sql.*;
//oracle의 jdbc driver=> ojdbc.jar ==> OracleDriver
public class DBConnect_Oracle {

	public static void main(String[] args) {
		try {
			//1.Driver로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//OracleDriver객체를 생성해서 DriverManager에 드라이버를 등록한다
			
			System.out.println("Driver Loading Success...");
			//2.DB 연결 => DriverManger.getConnection()을 이용
			String url="jdbc:oracle:thin:@localhost:1521:XE";
					// 프로토콜:dbms유형:드라이버타입:@host:port:전역데이터베이스
			String user="scott",pwd="tiger";
			
			Connection con = DriverManager.getConnection(url,user,pwd);
			System.out.println("DB Connected...");
			
			//3.SQL문 작성 => java_member 테이블을 생성하는 문장
			String sql = "CREATE TABLE java_member(";
				   sql+= " id varchar2(20) primary key,";
				   sql+= " pw varchar2(10) not null,";
				   sql+= " name varchar2(30) not null,";
				   sql+= " tel varchar2(15),";
				   sql+= " indate date default sysdate)";
		    //System.out.println(sql);
			//4.Statement객체 얻어오기 = con.createStatement()
		    Statement stmt = con.createStatement();
		    //5.Statement의 executeXXX()메서드 이용해서 쿼리문 실행
		    boolean b= stmt.execute(sql);
		    System.out.println("b: " + b);
		    //sql문이 select문이면 true를 반환
		    //select문이 아니면 false를 반환
		    
		    //6. DB 연결자원 반납
		    if(stmt != null) stmt.close();
		    if(con != null) con.close();
		    
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
