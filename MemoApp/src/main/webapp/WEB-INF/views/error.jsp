<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>에러 발생</title>

</head>
<body>

    <div class="error-box">
        <h2>에러 발생</h2>
        <p><%= request.getAttribute("errorMessage") != null 
                ? request.getAttribute("errorMessage") 
                : "알 수 없는 오류가 발생했습니다." %></p>
        <a href="<%= request.getContextPath() %>/">메인으로 돌아가기</a>
    </div>

</body>
</html>