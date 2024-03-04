<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.*" %>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String saveId = request.getParameter("saveId");//id 저장 체크박스
	System.out.println("saveId: " + saveId);
	
	if(id == null || pw == null || id.trim().isBlank() || pw.trim().isBlank()){
		response.sendRedirect("login.jsp");
		return;
	}
	MemberDAO userDao = new MemberDAO();
	int result = userDao.loginCheck(id, pw);
	if(result>0){
		//회원 인증 성공시 =>세션에 id 저장
	    //session내장객체: HttpSession타입
	    session.setAttribute("loginId", id);
		//하나의 브라우저 사용하는 동안 또는 세션 타임아웃(30분) 되기 전까지
		//세션에 저장한 정보는 계속 유지된다
		Cookie ck = new Cookie("uid",id);
		if(saveId != null ){
		//saveId에 체크했다면 ==> 쿠키에 "uid" 라는 키값으로 로그인한 사람의 id를 저장한다, 유효시간 7주일 정도 설정
			ck.setMaxAge(7*24*60*60);
		}else{
		//saveId에 체크하지 않았다면 ==> 쿠키 삭제
			ck.setMaxAge(0);
		}
		ck.setPath("/");
		//response에 쿠키 추가
		response.addCookie(ck);
		//쿠키 꺼내기 ==> login.jsp에서 한다
		
	}
	
	
	String msg = (result>0)?"환영합니다!!" + id + "님": "아이디 또는 비밀번호가 일치하지 않아요";
	String loc = (result>0)?"../index.jsp":"javascript:history.back()";
%>
<script>
	alert('<%=msg%>');
	location.href='<%=loc%>';
</script>
    