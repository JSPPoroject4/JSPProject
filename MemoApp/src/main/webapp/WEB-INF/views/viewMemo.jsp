<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>메모 상세</title>
    <link rel="stylesheet" href="/MemoApp/src/main/webapp/resources/css/viewmemo.css">
</head>
<body>
    <h2>메모 상세보기</h2>

    <c:if test="${not empty memo}">
        <div class="memo-card">
        <p><strong>제목:</strong> ${memo.memoTitle}</p>
        <p><strong>내용:</strong> ${memo.memoContent}</p>
        <p><strong>작성일:</strong> ${memo.createDate}</p>
        <p><strong>수정일:</strong> ${memo.modifyDate}</p>
        </div>
    </c:if>

    <div class="back-link">
    <a href="index.jsp">← 메인으로</a>
    </div>
</body>
</html>