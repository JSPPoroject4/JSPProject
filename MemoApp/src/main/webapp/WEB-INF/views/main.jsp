<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Memo List</title>

<link rel="stylesheet" href="/MemoApp/src/main/webapp/resources/css/main.css">
</head>

<body>

   <aside>
  <!-- 로그인/로그아웃 목록 -->
  <c:if test="${empty sessionScope.loginMember}">
    <form action="/login" method="post">
        아이디 : <input type="text" name="userId"> <br>
        비밀번호 : <input type="password" name="userPw"> <br>
        <button>로그인</button>
    <button>로그아웃</button>
    <button>회원가입</button>
    </form>
  </c:if>
 </aside> 






    <!-- js연결 -->>
    <script src="/MemoApp/src/main/webapp/resources/js/main.js"></script>

</body>    
</html>