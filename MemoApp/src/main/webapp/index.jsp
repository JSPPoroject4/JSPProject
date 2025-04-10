<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .horizontal {
        display: flex;
        gap: 10px; /* 요소 간 여백 */
        align-items: flex-start;
    }
</style>
</head>
<body>
	<h1>메인페이지</h1>
	
	<form action="/MemoApp/signup" method = "post" id="signup-form">
		<fieldset class="horizontal" >
			<legend>회원가입</legend>
			<img src="${pageContext.request.contextPath}/images_signup/signup.png" width = "100px">
			<table >
				<tr>
					<th>ID</th>

					<td><input type="text" name ="id"placeholder = "ID.."></td>
					
				</tr>
				<tr>
					<td colspan = "2">
						<c:if test="${not empty error}">
    						<p style="color: red; margin:0px 0px 8px 0px" >${error}</p>
						</c:if>	
					</td>
								
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name ="pw"placeholder = "PW.."></td>
				</tr>
				
				<tr>
					<th>PW확인</th>
					<td><input type="password" name ="pw-check"placeholder = "PW 확인.."></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name ="nickname"placeholder = "닉네임.."></td>
				</tr>
				<tr>
					<td colspan = "2">
						<div style="float: right;">
							<button id="button-signup-submit" >회원가입</button>
						</div>
					</td>
				</tr>

			</table>
		</fieldset>
	</form>
	
	<hr>
	<!-- 김동준 작성 -->
<!--  메모 검색창 -->
	<div class="search-bar">
		<form id="addForm" action="search" method="get">
			<input type="text" name="title" placeholder="메모 제목을 검색하세요" id="searchTitle" required>
			<button type="submit">검색</button>
		</form>
		<c:if test="${not empty errorMsg}">
			<p class="error-msg" style="color: red;">${errorMsg}</p>
		</c:if>
	</div>

	<!-- 메모 목록 -->
	<h2>메모 목록</h2>
	<!-- 메모 목록 보는 버튼 -->
	<form action="${pageContext.request.contextPath}/viewlist" method="get">
    <button type="submit">메모 목록 보기</button>
</form>
	<!-- 메인화면에 메모 출력 -->
<c:if test="${empty memos}">
	<p>메모가 없습니다.</p>
</c:if>

<c:forEach var="memo" items="${memos}">
	<div class="memo-item">
		<a href="viewMemo.do?memoNo=${memo.memoNo}" style="text-decoration: none;">
			<strong>${memo.title}</strong> - ${memo.date}
		</a>
	</div>
</c:forEach>

	<!-- JS 파일 연결 -->
	<script src="${pageContext.request.contextPath}/resources/js/signup.js"></script>
	<!-- main.js 파일 연결 -->
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>