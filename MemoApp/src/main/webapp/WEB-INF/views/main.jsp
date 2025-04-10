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
    <style>
        .horizontal {
            display: flex;
            gap: 10px;
            align-items: flex-start;
        }
    </style>
</head>

<body>

    <h1>메인 페이지1</h1>
    
    <div id="header"></div>
    <div>
        <div>
            <!-- 로그인 안되어 있으면 로그인 폼 표시 -->
            <c:if test="${empty sessionScope.loginMember}">
                <form action="/login" method="post">
                    <fieldset class="horizontal" style="max-width: 380px">
                        <legend>로그인</legend>
                        <table>
                            <tr>
                                <th>ID</th>
                                <td><input type="text" name="id-login" placeholder="ID" style="margin: 0px 0px 0px 3px"></td>
                            </tr>
                            <tr>
                                <th>PW</th>
                                <td><input type="password" name="pw-login" placeholder="PW" style="margin: 0px 0px 0px 3px"></td>
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

            <!-- 로그인 되어 있으면 환영 메시지 + 로그아웃 버튼 -->
            <c:if test="${not empty sessionScope.loginMember}">
                <p>${sessionScope.loginMember} 환영합니다!</p>
                <button type="button" id="logout">로그아웃</button>
            </c:if>

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
                                    <p style="color: red; margin:0px 0px 8px 0px">${error}</p>
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
                                    <button id="button-signup-submit">회원가입</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>

        <div>
            <!-- 로그인 여부에 따라 메모 표시 -->
        </div>
    </div>

    <!-- 세션 메시지 표시 -->
    <c:if test="${not empty sessionScope.message}">
        <script>
            alert("${message}");
        </script>
        <c:remove var="message" scope="session" />
    </c:if>

    <!-- 스크립트 영역 -->
    <script>
        // 로그아웃 버튼 클릭 시 로그아웃 처리 경로로 이동
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
