package day02;
import java.sql.*;
public class Select_MySQL {

	public static void main(String[] args) 
	throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root",pwd="1234";
		Connection con = DriverManager.getConnection(url,user,pwd);
		
		String sql="SELECT name,id,tel,indate FROM java_member ORDER BY indate DESC,name;";
		
		Statement stmt = con.createStatement();
		//		boolean b=stmt.execute(sql);
		//		System.out.println("b: "+b);
		
		//SELECT문일 경우
		//public ResultSet executeQuery(String sql) 메서드를 이용하다
		ResultSet rs = stmt.executeQuery(sql);
		//Result의 주요 메서드
		//public boolean next(): 논리적 커서의 기본 위치=> beforeFirst에 위치하고 있다가
		//                       next()가 호출되면 커서를 다음칸으로 이동한다. 이동한 곳에 record가
		//                       있으면 true를 반환,없으면 false를 반환
        //public String getString()/getInt()/getFloat()/getDouble()/getLong()...
		while(rs.next()) {
			String name = rs.getString("name");
			String id = rs.getString("id");
			String tel = rs.getString("tel");
			Date indate=rs.getDate("indate");
			System.out.printf("%s\t%s\t%s\t%s\n",name,id,tel,indate.toString());
		}
		
		if(rs!=null) rs.close();
		if(con!=null) con.close();
		if(stmt!=null) stmt.close();
		
		
		
	}

}
