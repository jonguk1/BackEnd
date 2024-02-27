package member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.*;

/*MemberUpdateEndServlet 작성
/MemberUpdateEnd => url-pattern

1. id,name,tel,pw 값 받기

2. 유효성 체크 => redirect=> member/mypage.html

3. MemberVO객체에 1번에서 받은 값 넣어주기

4. MemberDAO의 updateMember(vo객체) 호출

5. 그 결과 메시지 및 이동경로 지정
 * 
 * **/
@WebServlet("/MemberUpdateEnd")
public class MemberUpdateEndSelvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String pw = req.getParameter("pw");
		
		if(id == null || id.trim().isBlank() || name == null || name.trim().isBlank() || 
			tel == null || tel.trim().isBlank()|| pw == null || pw.trim().isBlank() ) {
			res.sendRedirect("member/mypage.html");
			return;
		}
		
		MemberVO user = new MemberVO(id, pw, name, tel, null);
		
		MemberDAO userDao = new MemberDAO();
		try {
			int n = userDao.updateMember(user);
			
			String msg = (n>0)?"회원정보 수정 완료" : "회원정보 실패- 아이디는 수정할 수 없어요";
			String loc = (n>0)?"member/mypage.html":"javascript:history.go(-1)";
			
			out.println("<script>");
			out.println("alert('"+msg+"')");
			out.println("location.href ='"+loc+"'");
			out.println("</script>");
		}catch(SQLException e) {
			e.printStackTrace();
			out.println("<b>서버 에러: " + e.getMessage() + "</b><br>");
		}
		out.close();
	}

}
