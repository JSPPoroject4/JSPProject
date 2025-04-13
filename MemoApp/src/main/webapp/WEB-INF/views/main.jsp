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
    <header>
        <img src="/MemoApp/src/main/webapp/resources/images/logo.jpg" width="40px" height="auto">
        <h1>MEMO APP</h1>
    </header>

    <hr><br><br>

        <div>

            <c:if test="${empty sessionScope.loginMember}">
            <form action="${pageContext.request.contextPath}/login" method="post">
    <fieldset class="horizontal" style="max-width: 380px">
        <legend>로그인</legend>
        <table>
            <tr>
                <th>ID</th>
                <td><input type="text" name="id-login" placeholder="ID" style="margin-left: 3px;"></td>
            </tr>
            <tr>
                <th>PW</th>
                <td><input type="password" name="pw-login" placeholder="PW" style="margin-left: 3px;"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div><button>로그인</button></div>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
            </c:if>

            <c:if test="${not empty sessionScope.loginMember}">
				<span id="nickname">${sessionScope.loginMember.nickname}님, 오늘의 할 일을 확인해보세요</span>
                <button type="button" id="logout">로그아웃</button>

                <div style="margin-top: 20px;">
                    <form action="${pageContext.request.contextPath}/memo" method="get">
                        <button type="submit">메모 작성</button>
                    </form>
                </div>

                <%-- 메모 검색 출력 --%>
                <form action="${pageContext.request.contextPath}/memo/search" method="get">
                    <input type="text" name="keyword" placeholder="메모 검색" required>
                    <button type="submit">검색</button>
                </form>

                <h2 style="text-align:center;">내 메모 목록</h2>

                <table>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th><!-- 작성자 추가 -->
                        <th>작성일</th>
                        <th>수정일</th>
                    </tr>

                    <c:forEach var="memo" items="${memoList}">
                        <tr>
                            <td>${memo.memoNo}</td>
                            <td>
                                <a href="<%= request.getContextPath() %>/viewMemo?no=${memo.memoNo}">
                                    ${memo.memoTitle}
                                </a>
                            </td>
                            <td>${memo.member.nickname}</td> <!-- 작성자 추가 -->
                            <td>${memo.createDate}</td>
                            <td>${memo.modifyDate}</td>
                        </tr>
                    </c:forEach>

                </table>

            </c:if>

            <c:if test="${empty sessionScope.loginMember}">
                <form action="${pageContext.request.contextPath}/signup" method="post" id="signup-form">
                    <fieldset class="horizontal" style="max-width: 380px">
                        <legend>회원가입</legend>
                        <img src="${pageContext.request.contextPath}/images_signup/signup.png" width="100px">
                        <table>
                            <tr>
                                <th>ID</th>
                                <td><input type="text" name="id-signup" placeholder="ID.."></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${not empty error}">
                                        <p style="color: red; margin:0 0 8px 0;">${error}</p>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <th>PW</th>
                                <td><input type="password" name="pw-signup" placeholder="PW.."></td>
                            </tr>
                            <tr>
                                <th>PW확인</th>
                                <td><input type="password" name="pw-check-signup" placeholder="PW 확인.."></td>
                            </tr>
                            <tr>
                                <th>닉네임</th>
                                <td><input type="text" name="nickname-signup" placeholder="닉네임.."></td>
                            </tr>
                            <tr>
                                <td colspan="2">

                                    <div style="float: right;">
                                    <td colspan="2">
                                            <button id="button-signup-submit" style="width: 100%;">회원가입</button>
                                    </td>
                                    </div>

                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </c:if>
        </div>


        <c:if test="${not empty sessionScope.message}">
            <script>
                alert("${message}");
            </script>
            <c:remove var="message" scope="session" />
        </c:if>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const logoutBtn = document.getElementById("logout");
                if (logoutBtn) {
                    logoutBtn.addEventListener("click", function () {
                        window.location.href = "${pageContext.request.contextPath}/logout";
                    });
                }
            });
        </script>


<script src="/MemoApp/resources/js/signup.js"></script>
<script src="/MemoApp/resources/js/main.js"></script>

</body>
</html>