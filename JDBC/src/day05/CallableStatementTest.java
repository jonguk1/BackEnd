package day05;
import java.sql.*;
import jdbc.util.*;
import java.util.*;
/* CallableStatement
 * - 프로시저 호출할 때 사용한다
 * - Connection의 prepareCall(query)을 통해 호출
 * [1] 인 파라미터가 있을 경우
 * 		{call 프로시저명(인파라미터)}
 * [2] 프로시저명만 있을 경우
 * 		{call 프로시저명}
 * -------------------------------
 * [실습] bbs에 게시글을 등록하는 프로시저를 작성하고
 * 		jdbc통해 해당 프로시저를 호출해보자
 * create or replace procedure bbs_add
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
 * */
public class CallableStatementTest {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Title: ");
		String title = sc.nextLine();
		
		System.out.println("Writer: ");
		String writer = sc.nextLine();
		
		System.out.println("Content: ");
		String content = sc.nextLine();
		System.out.println(title+"/"+writer+"/"+content);
		
		Connection con = DBUtil.getCon();
		String sql = "{call bbs_add(?,?,?)}";
		
		CallableStatement cstmt = con.prepareCall(sql);
		
		cstmt.setString(1, title);
		cstmt.setString(2, writer);
		cstmt.setString(3, content);
		
		cstmt.execute();
		
		cstmt.close();
		con.close();
		System.out.println("게시글 등록 완료!!!");

	}

}
