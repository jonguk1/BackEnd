package day05;
import java.sql.*;
import jdbc.util.DBUtil;
/**참조 커서(refcursor)를 이용해서 프로시저 결과를 ResultSet으로 받아보자
 * -----------------------
 * create or replace procedure bbs_list
(mycr out sys_refcursor)
is
begin
    open mycr for
    select no,title,writer,content,wdate from bbs
    order by no desc;
end;
/
 * */
public class CallableStatementTest2 {

	public static void main(String[] args) {
		String sql = "{call bbs_list(?)}"; //아웃 파라미터의 Cursor타입
		try(Connection con = DBUtil.getCon(); CallableStatement cs = con.prepareCall(sql);) {
			//아웃 파라미터 값 세팅
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();//프로시저 실행
			ResultSet rs = (ResultSet)cs.getObject(1);
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Date wdate = rs.getDate("wdate");
				System.out.printf("%d\t%s\t%s\t%s\t%s\n",no,title,writer,wdate.toString(),content);
			}
			rs.close();
			cs.close();
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
