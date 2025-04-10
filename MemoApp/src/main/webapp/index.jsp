<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	<form action="/login" method = "post">
		<fieldset>
			<legend>회원가입</legend>
			
			<table >
				<tr>
					<th>ID</th>
					<td><input type="text"id ="id" name="id" placeholder = "ID.."></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" id ="pw" name="pw" placeholder = "PW.."></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" id ="nickname" name="nickname" placeholder = "닉네임.."></td>
				</tr>
				<button id="submitBtn" type="submit">회원가입</button>
			</table>
			
		</fieldset>
	</form>
	
	<script src="/resources/js/main.js"></script>
	
</body>
</html>