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

            <!-- 로그인 X: 로그인 폼 표시 -->
            <c:if test="${empty sessionScope.loginMember}">
            <!-- 로그인 수정 김동준 -->
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

            <!-- 로그인 O: 환영 메시지, 로그아웃 버튼, 메모 작성 버튼 -->
            <c:if test="${not empty sessionScope.loginMember}">
                <p>${sessionScope.loginMember} 님, 환영합니다!</p>
                <button type="button" id="logout">로그아웃</button>

                <div style="margin-top: 20px;">
                    <form action="${pageContext.request.contextPath}/memo" method="get">
                        <button type="submit">메모 작성</button>

                    </form>
                </c:if>
    
                <!-- 로그인 O: 환영 메시지, 로그아웃 버튼, 메모 작성 버튼 -->
                <c:if test="${not empty sessionScope.loginMember}">
                    <div style="display: flex; justify-content: flex-end; align-items: center; gap: 12px; padding: 10px;">
                        <p>${sessionScope.loginMember} 님, 환영합니다!</p>

            <!-- 회원가입 폼: 로그인 X일 때만 표시 -->
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

        <div>
            <!-- 로그인 상태에서만 메모 출력 -->
            <c:if test="${not empty sessionScope.loginMember}">
                <%-- 메모 검색 출력 --%>
                <form action="${pageContext.request.contextPath}/memo/search" method="get">
    <input type="text" name="keyword" placeholder="메모 검색" required>
    <button type="submit">검색</button>
</form>
                
            </c:if>

        </div>
    
        <!-- 세션 메시지 출력 (한 번만) -->
        <c:if test="${not empty sessionScope.message}">
            <script>
                alert("${message}");
            </script>
            <c:remove var="message" scope="session" />
        </c:if>
    
        <!-- 로그아웃 버튼 클릭 시 로그아웃 처리 -->
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

        <c:remove var="message" scope="session" />
    </c:if>

    <!-- 로그아웃 버튼 클릭 시 로그아웃 처리 -->
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
<!-- js파일 경로 변경 김동준 -->
<script src="/MemoApp/resources/js/signup.js"></script>
<script src="/MemoApp/resources/js/main.js"></script>



</body>
</html>