<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,bbs.model.*" %>
<jsp:include page="/inc/top.jsp" />
<jsp:useBean id="dao" class="bbs.model.BbsDAO" scope="session" />

		<!-- content -->
		<div class= "container">
			<h1>Board List Page</h1>
			<br>
			[<a href = "input.jsp">글쓰기</a>]
			<br><br>
			<table border="1">
				<tr>
					<th class="m1" width="10%">글번호</th>
					<th class="m1" width="50%">글제목</th>
					<th class="m1" width="20%">작성자</th>
					<th class="m1" width="20%">작성일</th>
				</tr>
				<!-- ------------- -->
				<%
					//BbsDAO bbs = new BbsDAO();
					ArrayList<BbsVO> arr= dao.listBbs();
					if(arr == null || arr.size() ==0){
				%>
						<tr>
							<td colspan="4"><b>데이터가 없습니다</b></td>
						</tr>
				<% 
					}else{
						for(BbsVO vo:arr){
				%>
							<tr>
								<td><%=vo.getNo() %></td>
								<td><%=vo.getTitle() %></td>
								<td><%=vo.getWriter() %></td>
								<td><%=vo.getWdate() %></td>
							</tr>
				<%
						}
					}
				%>
				<!-- ------------- -->
			</table>
		</div>
<jsp:include page="/inc/foot.jsp" />