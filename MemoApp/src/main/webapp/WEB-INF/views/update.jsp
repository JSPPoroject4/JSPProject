<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${memo.memoTitle} 수정 페이지</title>
<link rel="stylesheet" href="/MemoApp/resources/css/update.css">
<style>
    body {
        font-family: sans-serif;
        margin: 20px;
        background-color: #f4f4f4;
    }

    h1 {
        color: #3b73e8;
        text-align: center;
        margin-top: 30px;
    }

    h4 {
        color: #3b73e8;
        text-align: center;
        margin-bottom: 20px;
    }

    form {
        max-width: 500px;
        margin: 30px auto;
        padding: 20px;
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    div {
        margin-bottom: 15px;
    }

    label {
        display: block;
        color: #555;
        margin-bottom: 5px;
    }

    input[type="text"],
    textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }

    textarea {
        resize: vertical;
        min-height: 100px;
    }

    button[type="submit"] {
        background-color: #3b73e8;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }

    button[type="submit"]:hover {
        background-color: #2c5bb0;
    }
</style>
</head>
<body>

	<h1>${sessionScope.loginMember.nickname}의 수정</h1>

	<h4>할 일 수정</h4>

	<%--
		/memo/update - POST 방식 요청
				-> UpdateServlet 클래스에 doPost() 오버라이딩
	 --%>

	<form action="${pageContext.request.contextPath}/memo/update" method="post" id="updateForm">
		<div>
			제목 : <input type="text" name="title" value="${memo.memoTitle}">
		</div>
		<div>
			<textarea name="detail" rows="3" cols="50" placeholder="상세 내용..">${memo.memoContent}</textarea>
		</div>


		<%--
			memoNo 도 수정 요청 시 파라미터로 보내기
			왜?
			어떤 memoNo를 가진 행을 수정하고자 하는 것인지
			SQL의 WHERE(조건식)에서 이용해야하기 때문.

			param. -> url(/memo/update?memoNo=1)에 있는 ?memoNo=1
			EL 표현식에서 ${param.key} -> ${param.memoNo} -> 1 반환
		 --%>
		<input type="hidden" name="memoNo" value="${param.memoNo}">

		<button type="submit">수정 완료</button>
	</form>


	<%-- session 범위에 message가 있을 경우 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>

		<c:remove var="message" scope="session" />
	</c:if>


</body>
</html>