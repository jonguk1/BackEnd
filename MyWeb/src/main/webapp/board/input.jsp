<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/inc/top.jsp" />
		<!-- bbs관련 js파일 참조 ----------------->
		<script src="../js/bbs.js"></script>
		<!-- ------------------------------ -->
		<%
			String loginId = (String)session.getAttribute("loginId");
		%>
		<!-- content -->
		<div class= "container">
			<h1>Board Input Page</h1>
			<br><br>
			<form name="bbsF" method="post" action="insert2.jsp" onsubmit="return bbs_check()">
				<table border="1">
					<tr>
						<th width="20%">글 제목</th>
						<td width="80%">
							<input type="text" name="title" id="title" placeholder="Title">
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<input type="text" name="writer" id="writer" readonly
							<% if(loginId != null){ %>
							value ="<%=loginId %>"
							<%} %>
							placeholder="Writer">
						</td>
					</tr>
					<tr>
						<th>글내용</th>
						<td>
							<textarea name="content" id = "content" placeholder="Content" rows="7" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center;">
							<button>글쓰기</button>
							<button type="reset">다시쓰기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
<jsp:include page="/inc/foot.jsp" />