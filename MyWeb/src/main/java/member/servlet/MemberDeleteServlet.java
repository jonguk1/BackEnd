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

@WebServlet("/MemberDelete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		res.setCharacterEncoding("UTF-8");
		
		//1. 아이디 값 받기
		String id = req.getParameter("id");
		
		//2. 유효성 체크
		if(id == null || id.trim().isEmpty()) {
			res.sendRedirect("member/mypage.html");
			//페이지 이동을 시킴 ==> 브라우저의 url을 member/mypage.html
			//로 변경하여 서버에 새롭게 요청을 보내는 방식으로 페이지를
			//이동한다
			return;
		}
		//3.MemberDAO 객체 생성,delete(id)
		MemberDAO userDao = new MemberDAO();
		try {
			int n =userDao.deleteMember(id);
			String msg = (n>0) ? "회원 탈퇴 완료":"회원 탈퇴 실패: 아이디를 확인하세요";
			String loc = (n>0) ? "index.html" : "javascript:history.back()";
			
			//4. 그 결과 메세지 페이지 이동 처리
			out.println("<script>");
			out.println("alert('" + msg + "')");
			out.println("location.href='" + loc + "'"
					+ "");
			out.println("</script>");
			
		}catch(SQLException e) {
			out.println("<b>서버 에러:"+e.getMessage()+"</b><br>");
			e.printStackTrace();
		}
		
		out.close();
		
	}

}
