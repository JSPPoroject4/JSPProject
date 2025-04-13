<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${memo.memoTitle} 상세 조회</title>
	<link rel="stylesheet" href="/MemoApp/src/main/webapp/resources/css/detail.css">

	
</head>
<body>
	 <!-- css 변경 -->

	 <header>
		<img src="https://cdn-icons-png.flaticon.com/128/6467/6467161.png" 
			 alt="아이콘"
			 style="height: 30px; filter: brightness(0) invert(1); vertical-align: middle;">
	</header>
	  
	<h1>${sessionScope.loginMember}</h1>
	
	<h1>${memo.memoTitle}</h1>

	<div class="complete">
		<span class="info-badge">
			완료 여부 :
			<c:if test="${memo.memoComplete}">
				<span class="check">O</span>
			</c:if>
			<c:if test="${not memo.memoComplete}">
				<span class="check">X</span>
			</c:if>
		</span>
	</div>
	
	<div>
		<span class="info-badge">작성일 : ${memo.regDate}</span>
	</div>

	<div class="content">${memo.memoDetail}</div>
	
	<div class="btn-container">
		<div>
			<button id="completeBtn">완료 여부 변경</button>
			<button id="updateBtn">수정</button>
			<button id="deleteBtn">삭제</button>
		</div>


		<br><br><br>

		<div>
			<button type="button" id="goToList">← 목록으로</button>
		</div>
	
	</div>
	
	
	
	<%-- session 범위에 message가 있을 경우 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>
		
		<c:remove var="message" scope="session" />
	</c:if>
	
	
	<script src="/resources/js/detail.js"></script>
</body>
</html>