<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 작성</title>
    <link rel="stylesheet" href="/MemoApp/resources/css/wirte.css">
</head>
<body>

    <header>
        <h1>메모 작성하기</h1>
    </header>

   <form action="${pageContext.request.contextPath}/memo/list" method="post">

        <fieldset>
            <legend>Memo</legend>

            <label>제목:</label><br>
            <input type="text" name="title" required><br><br>

            <label>내용:</label><br>
            <textarea name="content" rows="5" cols="50" required></textarea><br><br>

            <button type="submit">작성 완료</button>
        </fieldset>
    </form>

    <div class="back-link">
        <a href="${pageContext.request.contextPath}/">← 메인으로 돌아가기</a>
    </div>

</body>
</html>
