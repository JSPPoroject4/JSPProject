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
	<form action="/MemoApp/signup" method = "post" id="signup-form">
		<fieldset class="horizontal" style = "max-width" >
			<legend>회원가입</legend>
			<img src="${pageContext.request.contextPath}/images_signup/signup.png" width = "100px">
			<table >
				<tr>
					<th>ID</th>

					<td><input type="text" name ="id-signup"placeholder = "ID.."></td>
					
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
					<td><input type="password" name ="pw-signup" placeholder = "PW.."></td>
				</tr>
				
				<tr>
					<th>PW확인</th>
					<td><input type="password" name ="pw-check-signup" placeholder = "PW 확인.."></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name ="nickname-signup" placeholder = "닉네임.."></td>
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

	<script src="${pageContext.request.contextPath}/resources/js/signup.js"></script>


</body>
</html>