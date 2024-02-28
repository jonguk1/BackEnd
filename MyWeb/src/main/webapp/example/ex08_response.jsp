<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>ex08_response.jsp 페이지입니다</h1>
<p> response객체의 주요 메서드
	- sendRedirect(페이지)<br>
	- sendError(에러코드)<br>
</p>
<%
//1. 아이디와 비번값 받아서 브라우저에 출력하세요
	String id = request.getParameter("uid");
	String pw = request.getParameter("pwd");
%>
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=pw %></h3>
<%
//2. null값이면 ex08_form.jsp로 redirect 이동시키기
	if(id == null || pw == null){
		response.sendRedirect("ex08_form.jsp");
		return;
	}
//3. //빈문자열일 경우 잘못된 요청 에러를 출력하세요 -400
	if(id.trim().isBlank() || pw.trim().isBlank()){
		//response.sendError(400);
		response.sendError(HttpServletResponse.SC_BAD_GATEWAY);//400
		return;
//4. killer가 들어오면 접근 금지 에러를 출력하세요 -403
	}else if (id.equals("killer")){
		response.sendError(HttpServletResponse.SC_FORBIDDEN);//403
		return;
	}
//5.uid가 redirect라면 "welcome.jsp"로 redirect방식으로 이동시키세요
	if(id.equals("redirect")){
		
		request.setAttribute("msg", id + "님 정말 환영해요!!");
		session.setAttribute("msg", id+ "님 정말 환영해요!!!");
		
	    response.sendRedirect("welcome.jsp");
	    return;
//6.uid가 forward라면 "welcome.jsp"로 forward방식으로 이동시키세요
	}else if (id.equals("forward")){
		request.setAttribute("msg", id + "님 정말 환영해요!!");
		session.setAttribute("msg", id+ "님 정말 환영해요!!!");
%>
	<jsp:forward page="welcome.jsp"/>
<%
	}
%>
	
	
	