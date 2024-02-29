<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bbs.model.*"%>
<%@ page errorPage="/error.jsp" %>
<!-- 에러가 발생하면 error.jsp 페이지에서 처리하겠다는 설정 -->    
<%
	//1. post 방식일때 한글처리
	//request.setCharacterEncoding("UTF-8"); //== 한글처리 Filter를 만들어 사용하자
	//2. 사용자가 입력한 값 받기
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	//3. 유효성 체크
	if(title == null || writer == null||title.trim().isBlank()||writer.trim().isBlank()){
		response.sendRedirect("input.jsp");
		return;
	}
	
	//4. 2번에서 받은 값을 BbsVO객체에 담기
	BbsVO vo = new BbsVO(0,title,writer,content,null);
	//5. BbsDAO 의 insertBBS(vo객체)
	BbsDAO dao =new BbsDAO();
	
	int n =dao.insertBbs(vo);
	//6. 그 결과 메세지,이동경로 처리
	String msg = (n>0)?"글쓰기 성공":"글쓰기 실패";
	String loc = (n>0)?"list.jsp":"javascript:history.back()";
%>
<script>
	alert('<%=msg %>');
	location.href='<%=loc %>';
</script>
