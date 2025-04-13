<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 리스트</title>
</head>
<body>
    <h1>메모 리스트</h1>
    <c:if test="${not empty memoList}">
        <c:forEach var="memo" items="${memoList}">
            <div>
                <h3>${memo.memoTitle}</h3>
                <p>${memo.memoContent}</p>
                <small>작성자: ${memo.member.nickname}</small>
            </div>
            <hr>
        </c:forEach>
    </c:if>
    <c:if test="${empty memoList}">
        <p>작성된 메모가 없습니다.</p>
    </c:if>
</body>
</html>