package day04;
import java.util.*;
import jdbc.util.DBUtil;
import java.sql.*;

public class Select_Java_Member2 {

	public static void main(String[] args) throws Exception{
		//bbs에서 게시글을 검색하되 제목에 들어간 키워드로 검색
		Scanner sc = new Scanner(System.in);
		System.out.println("게시판 검색 키워드(title) 입력: ");
		String keyword = sc.nextLine();
		System.out.println("검색어: ["+keyword+"]");
		
		String sql = "SELECT no,title,writer,content,wdate FROM bbs WHERE title like '%'|| ? ||'%'";
			   sql+= "ORDER BY no DESC";
		
		Connection con =DBUtil.getCon();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, keyword);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString(1);
			String title = rs.getString(2);
			String writer = rs.getString(3);
			String content = rs.getString(4);
			java.sql.Date wdate = rs.getDate(5);
			System.out.printf("%s\t%s\t%s\t%s\t%s\n",no,title,writer,content,wdate);
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}

}
