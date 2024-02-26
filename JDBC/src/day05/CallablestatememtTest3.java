package day05;
import java.sql.*;
import java.sql.Date;

import jdbc.util.*;
import java.util.*;
/**create or replace procedure bbs_add
(
    ptitle in bbs.title%type,
    pwriter in bbs.writer%type,
    pcontent in bbs.content%type
)
is
begin
    insert into bbs(no,title,writer,content,wdate)
    values(bbs_no_seq.nextval,ptitle,pwriter,pcontent,sysdate);
    commit;
end;
/
--------------------------------------------
create or replace procedure bbs_list
(mycr out sys_refcursor)
is
begin
    open mycr for
    select no,title,writer,content,wdate from bbs
    order by no desc;
end;
/
----------------------
create or replace procedure bbs_find
(mycr out sys_refcursor, pwriter in bbs.writer%type)
is
begin
    open mycr for
    select no,title,writer,content,wdate from bbs
    where writer like '%'||pwriter||'%'
    order by no desc;
end;
/
--------------------
variable rs refcursor
exec bbs_find(:rs,'k');

print rs
 * */

public class CallablestatememtTest3 {

	public static void main(String[] args) 
	throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 작성자: ");
		String writer = sc.nextLine();
		
		Connection con = DBUtil.getCon();
		
		String sql = "{call bbs_find(?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);// out parameter type
		cs.setString(2, writer);
		cs.execute();
		ResultSet rs=(ResultSet)cs.getObject(1);
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer2 = rs.getString("writer");
			String content = rs.getString("content");
			Date wdate = rs.getDate("wdate");
			System.out.printf("%d\t%s\t%s\t%s\t%s\n",no,title,writer2,wdate.toString(),content);
		}
		rs.close();
		cs.close();
		con.close();
	}

}
