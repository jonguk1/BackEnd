<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- ----------------------------------------------- -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!-- 제어문은 core태그에 모여 있음. 숫자, 날짜 format은 fmt태그에 있음----- -->  
		<!-- content -->
		<div class="container">
			<h1>MVC Board</h1>
			<br>
			[<a href="input.do">글쓰기</a>]
			<br><br>
			<table border="1">
				<tr>
					<th class="m1" width="10%">글번호</th>
					<th class="m1" width="40%">글제목</th>
					<th class="m1" width="20%">작성자</th>
					<th class="m1" width="20%">작성일</th>
					<th class="m1" width="10%">조회수</th>
				</tr>
				<!--  --------------- boardArr.size() ==0-->
				<c:if test="${boardAll==null || empty boardAll }">
				<tr>
					<td colspan="5">
					<b>데이터가 없습니다</b>
					</td>
				</tr>
				</c:if>
				<c:if test="${boardAll !=null && not empty boardAll }">
				<%-- for(BoardVO board:boardAll){ ... } 와 동일함 --%>
					<c:forEach var="board" items="${boardAll}">
							<tr>
								<td>${board.num}</td>
								<td>
								<a href="view.do?num=${board.num}">${board.title}</a>
								
								<c:if test="${board.fileName ne null}">
									<img src="../images/attach.PNG" style="width:0.8em">
								</c:if>
								
								</td>
								<td>${board.name}</td>
								<td>
								<fmt:formatDate value="${board.wdate}" pattern="yyyy-MM-dd"/>
								</td>
								<td>${board.readnum}</td>
							</tr>
					</c:forEach>		
				</c:if>							
				<!-- ---------------- -->
				<tr>
					<td colspan="3" style="text-align:center">
					<!-- 페이지 네비게이션 -->
					<c:forEach var="i" begin="1" end="${pageCount}" step="1">
			[<a href="list.do?pageNum=${i}"
			  <c:if test="${pageNum ==i}">class='active'</c:if> >${i}</a>]
					</c:forEach>					
					</td>
					<td colspan="2" style="text-align:center">
						총 게시글 수
						<span style="color:red;font-weight:bold">${totalCount }</span>개
					</td>
				</tr>
			</table>
			<br><br>
			<!-- 검색 form 시작  ------------------------------------->
			<div id="divFind">
				<form name="findF" id="findF" action="find.do">
					<select name="findType">
						<option value="0">::검색 유형::</option>
						<option value="1">글제목</option>
						<option value="2">작성자</option>
						<option value="3">글내용</option>
					</select>	
					<input type="text" name="findKeyword" required
					 placeholder="검색어를 입력하세요">
					<button class="btn">검   색</button>				 
				</form>			
			</div>
		</div>
		
		
		    
		    
		    
		    