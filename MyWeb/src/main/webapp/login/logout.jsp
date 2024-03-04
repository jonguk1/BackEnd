<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 세션에 저장된 세션변수를 삭제하는 방법
	//session.removeAttribute("loginId");
	
	//2. 모든 세션변수를 삭제하는 방법 (권장)- invalidate()
	session.invalidate();
	
	response.sendRedirect("../index.jsp");

%>

