<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 상세</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 20px;
        }

        h2 {
            color: #3b73e8;
            text-align: center;
            margin-bottom: 20px;
        }

        p {
            color: #333;
            line-height: 1.6;
            margin-bottom: 10px;
        }

        p strong {
            color: #3b73e8;
            font-weight: bold;
        }

        div {
            margin-top: 20px;
            text-align: center;
        }

        button {
            background-color: #3b73e8;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 0 10px;
        }

        button:hover {
            background-color: #2c5bb0;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 30px;
            color: #3b73e8;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>메모 상세보기</h2>

    <c:if test="${not empty message}">
        <script>
            alert("${message}");
        </script>
    </c:if>

     <c:if test="${not empty memo}">
        <p><strong>제목:</strong> ${memo.memoTitle}</p>
        <p><strong>내용:</strong> ${memo.memoContent}</p>
        <p><strong>작성일:</strong> ${memo.createDate}</p>
        <p><strong>수정일:</strong> ${memo.modifyDate}</p>
        <div>
<button onclick="location.href='<%= request.getContextPath() %>/memo/update?memoNo=${memo.memoNo}'">수정</button>
            <button onclick="confirmDelete('${memo.memoNo}')">삭제</button>
        </div>

      </c:if>

<a href="http://localhost:8080/MemoApp/main">← 메인으로</a>

    <script>
        function confirmDelete(memoNo) {
            if (confirm('정말로 삭제하시겠습니까?')) {
                location.href = '<%= request.getContextPath() %>/memo/delete?memoNo=' + memoNo;
            }
        }
    </script>
    </body>
</html>