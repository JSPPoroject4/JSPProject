<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>검색 결과</title>
</head>
<body>
    <h2>검색 결과</h2>

    <c:choose>
        <c:when test="${not empty memoList}">
            <ul>
                <c:forEach var="memo" items="${memoList}">
                    <li>
                        <a href="viewMemo?memoNo=${memo.memoNo}">
                            ${memo.memoTitle}
                        </a>
                        <small>(작성일: ${memo.createDate})</small>
                    </li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p>검색 결과가 없습니다.</p>
        </c:otherwise>
    </c:choose>

<a href="main">← 다시 검색</a>

</body>
</html>