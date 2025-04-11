<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Memo List</title>
    <link rel="stylesheet" href="/MemoApp/src/main/webapp/resources/css/main.css">
    <style>
        .horizontal {
            display: flex;
            gap: 10px;
            align-items: flex-start;
        }
    </style>
</head>

<body>

    <h1>메인 페이지</h1>

    <div id="header"></div>

    <div>
        <!-- 로그인 안 되어 있을 때 -->
        <c:if test="${empty sessionScope.loginMember}">
            <!-- 로그인 폼 -->
            <form action="/login" method="post">
                <fieldset class="horizontal" style="max-width: 380px">
                    <legend>로그인</legend>
                    <table>
                        <tr>
                            <th>ID</th>
                            <td><input type="text" name="id-login" placeholder="ID"></td>
                        </tr>
                        <tr>
                            <th>PW</th>
                            <td><input type="password" name="pw-login" placeholder="PW"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><button>로그인</button></td>
                        </tr>
                    </table>
                </fieldset>
            </form>

            <!-- 회원가입 폼 -->
            <form action="/MemoApp/signup" method="post" id="signup-form">
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
                                    <p style="color: red;">${error}</p>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>PW</th>
                            <td><input type="password" name="pw-signup" placeholder="PW.."></td>
                        </tr>
                        <tr>
                            <th>PW 확인</th>
                            <td><input type="password" name="pw-check-signup" placeholder="PW 확인.."></td>
                        </tr>
                        <tr>
                            <th>닉네임</th>
                            <td><input type="text" name="nickname-signup" placeholder="닉네임.."></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: right;">
                                <button id="button-signup-submit">회원가입</button>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </c:if>

        <!-- 로그인 되었을 때 -->
        <c:if test="${not empty sessionScope.loginMember}">
            <p>${sessionScope.loginMember.nickname} 님, 환영합니다!</p>

            <div style="display: flex; gap: 10px; margin-bottom: 20px;">
                <button type="button" id="logout">로그아웃</button>
                <form action="${pageContext.request.contextPath}/memo/create" method="get" style="margin: 0;">
                    <button type="submit">메모 작성</button>
                </form>
            </div>
        </c:if>

        <!-- 메모 목록 영역 (로그인된 사용자만) -->
        <c:if test="${not empty sessionScope.loginMember}">
            <%-- 여기에 메모 리스트 표시 로직 추가 가능 --%>
        </c:if>
    </div>

    <!-- 메시지 알림 -->
    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${message}");
        </script>
        <c:remove var="message" scope="session" />
    </c:if>

    <!-- 로그아웃 기능 -->
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

    <script src="/resources/js/signup.js"></script>
    <script src="/resources/js/main.js"></script>

</body>
</html>
