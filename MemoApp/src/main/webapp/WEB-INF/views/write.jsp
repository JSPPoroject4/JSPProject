<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 작성</title>
</head>
<body>
    <h1>메모 작성하기</h1>
    
    <form action="${pageContext.request.contextPath}/memo" method="post">
        <label>제목:</label><br>
        <input type="text" name="title" required><br><br>

        <label>내용:</label><br>
        <textarea name="content" rows="5" cols="50" required></textarea><br><br>

        <button type="submit">작성 완료</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/">← 메인으로 돌아가기</a>
</body>
</html>
