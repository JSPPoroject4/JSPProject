<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 작성</title>
    <link rel="stylesheet" href="/MemoApp/resources/css/wirte.css">
    <style>
        header {
            text-align: center;
            margin-top: 30px;
        }

        header h1 {
            color: #3b73e8;
            margin: 0;
        }

        form {
            max-width: 500px;
            margin: 30px auto 0;
        }

        fieldset {
            border: 2px solid #3b73e8;
            border-radius: 8px;
            padding: 20px;
        }

        legend {
            color: #3b73e8;
            font-weight: bold;
            font-size: 18px;
        }

        label {
            color: #3b73e8;
        }

        input[type="text"],
        textarea {
            width: 100%;
            margin-bottom: 15px;
            padding: 8px;
            border: 1px solid #3b73e8;
            border-radius: 4px;
            color: #3b73e8;
            box-sizing: border-box;
        }

        button {
            background-color: #3b73e8;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        .back-link {
            text-align: center;
            margin-top: 20px;
        }

        .back-link a {
            color: #3b73e8;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
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