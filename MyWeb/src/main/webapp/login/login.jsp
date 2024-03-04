<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/inc/top.jsp"/>

<div class="container">
	<h1>Login</h1>
	<br><br>
	<%
		//쿠키 꺼내기
		boolean saveId = false;
		String uid = "";
		Cookie[] cks = request.getCookies();
		if(cks !=null){
			for(Cookie ck:cks){
				String key =ck.getName();
				if(key.equals("uid")){
					saveId = true;
					uid =ck.getValue();//저장한 아이디값
					break;
				}
			}
		}
		
	%>
	<form name="loginF" method="post" action="loginEnd.jsp">
		<table border="1" style="width:60%;margin:auto">
			<tr>
				<th width="20%">아이디</th>
				<td>
					<input type="text" name="id" required value="<%=uid%>">
				</td>
			</tr>
			<tr>
				<th width="20%">비밀번호</th>
				<td>
					<input type="password" name="pw" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
					<label for="saveId">
						<input type="checkbox" name="saveId" id = "saveId"
						<%if(saveId){ %>
							checked
						<% } %>
						 style="width:10% ">아이디 저장
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button> 로그인 </button>
				</td>
			</tr>
		</table>
	</form>
</div>


<jsp:include page="/inc/foot.jsp"/>