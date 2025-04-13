<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 메모장</title>
    <link rel="stylesheet" href="/MemoApp/src/main/webapp/resources/css/index.css">
</head>
<body>
 <!-- <head> 중복 수정 -->
    <header>
        <div class="logo">나의 메모장</div>
        <div class="auth-buttons">
            <c:choose>
                <c:when test="${not empty sessionScope.loginMember}">
                    <span id="nickname">${sessionScope.loginMember.memberNickname}님</span>
                    <button id="logout">로그아웃</button>
                </c:when>
                <c:otherwise>
                    <button id="login">로그인</button>
                    <button onclick="location.href='signup'">회원가입</button>
                </c:otherwise>
            </c:choose>
        </div>
    </header>

    <!-- 메모 검색 -->
    <section class="search-area">
        <h2>메모 검색</h2>
        <form action="search" method="get">
            <input type="text" name="title" placeholder="메모 제목을 입력하세요" required>
            <button type="submit">검색</button>
        </form>
    </section>

    <hr> 
    
    <!-- 메모 카드 목록 -->
        <main class="main-content">
            <h2>최근 메모</h2>
            <c:choose>
                <c:when test="${empty requestScope.memos}">
                    <p>작성된 메모가 없습니다.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="memo" items="${requestScope.memos}">
                        <div class="note-item">
                            <div>
                                <h3>${memo.memoTitle}</h3>
                                <p class="date">
                                    <c:choose>
                                        <c:when test="${not empty memo.modifyDate}">
                                            수정일: <fmt:formatDate value="${memo.modifyDate}" pattern="yyyy-MM-dd"/>
                                        </c:when>
                                        <c:otherwise>
                                            작성일: <fmt:formatDate value="${memo.createDate}" pattern="yyyy-MM-dd"/>
                                        </c:otherwise>
                                    </c:choose>
                                </p>
                            </div>
                            <button onclick="location.href='detail?memoNo=${memo.memoNo}'">🤍</button>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </main>🤍
   
    <!-- 경로 수정 김동준 -->
    <script src="/resources/js/main.js"></script>

</body>
</html>