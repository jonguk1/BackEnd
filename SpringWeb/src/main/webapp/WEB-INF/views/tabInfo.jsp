<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>scott������ ������ �ִ� ���̺� �Ǵ� ��</h1>
<hr color='red'>
<%-- ${tabList} --%>
<ul>
	<c:forEach var= "tab" items="${tabList}">
		<li>${tab.tname} : ${tab.tabType}</li>
	</c:forEach>
</ul>
</body>
</html>