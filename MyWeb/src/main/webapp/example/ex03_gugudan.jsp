<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<h1>구구단 전체를 테이블 형태로 출력하세요</h1>

<table border="1">
	<tr>
		<% 
			for(int dan=2; dan <=9; dan++){
		%>
			<th> <%= dan %>단</th>
		<%
		  }
		%>
	</tr>
	
	<%
		for(int i = 1; i<=9; i++){
	%>
	<tr>
		<% 
			for(int j =2; j <=9; j ++){
		%>
			<td> <%= j %> * <%=i %> = <%=i*j %></td>
		<%
		  }
		%>
	</tr>
	<%
	  }
	%>
</table>