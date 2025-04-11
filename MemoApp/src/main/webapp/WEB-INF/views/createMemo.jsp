<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>메모 작성</title>
</head>
<body>
    <h2>메모 작성</h2>
    <form action="${pageContext.request.contextPath}/memo/write" method="post">
        <textarea name="content" rows="5" cols="40" placeholder="메모를 입력하세요"></textarea><br><br>
        <button type="submit">작성 완료</button>
    </form>
</body>
</html>