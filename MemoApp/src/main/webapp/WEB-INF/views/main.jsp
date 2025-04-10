<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">

<title>Memo List</title>
<link style="stylesheet" href="/MemoApp/src/main/webapp/resources/css/main.css">

<style><!-- -->
    .horizontal {
        display: flex;
        gap: 10px; /* 요소 간 여백 */
        align-items: flex-start;
    }
</style>

</head>

<body>

	<h1>메인 페이지1</h1>
	
	<div id="header">
	
	</div>
	<div>
		<div>
			<!-- 로그인 안되있으면 로그인 -->
			
			<form>
				<fieldset  class="horizontal" style = "max-width : 380px">
					<legend>로그인</legend>
					<table>
						<tr>
							<th>ID</th>
							<td>
                                <input type="text" name="id-login"Placeholder="ID" style="margin: 0px 0px 0px 3px">
                            </td>
						</tr>
                        <tr>
                            <th>PW</th>
                            <td>
                                <input type="password" name="pw-login"placeholder="PW"  style="margin: 0px 0px 0px 3px">
                            </td>
                        </tr>
                        <tr colspan="2">
                            <td  >
                                <div >
                                    <button>로그인</button>
                                </div>
                            </td>
                        </tr>
					</table>
				</fieldset>
			</form>
	
		<!-- 로그인 안되있으면 회원가입 (signup.jsp에서 복붙함)-->
            <form action="/MemoApp/signup" method = "post" id="signup-form">
		<fieldset class="horizontal" style = "max-width : 380px" >
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

	
			<!-- 로그인 되어있으면 로그아웃 -->
		</div>
		<div>
			<!-- 로그인 안되있으면 메모 표시 X  -->
			<!-- 로그인 되있으면 메모 표시 O -->
		</div>
	</div>
	
	<%-- session 범위에 message가 있을 경우 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			// JS 영역
			alert("${message}");
			// JSP 해석 순위
			// 1순위 : Java(EL/JSTL)
			// 2순위 : Front(HTML/CSS/JS)
		</script>
		
		<%-- message를 한 번만 출력하고 제거 --%>
		<c:remove var="message" scope="session" />
	</c:if>
	
	<script src="/resources/js/signup.js"></script>


    <script src="/resources/js/main.js"></script>

</body>


</html>