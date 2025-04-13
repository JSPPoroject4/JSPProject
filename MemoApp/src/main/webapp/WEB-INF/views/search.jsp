<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 목록</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        a {
            text-decoration: none;
            color: black;
        }
        a:hover {
            text-decoration: underline;
            color: blue;
        }
        .btn-home {
            display: block;
            width: 200px;
            margin: 30px auto;
            padding: 10px;
            text-align: center;
            background-color: #eee;
            border: 1px solid #ccc;
            border-radius: 8px;
            text-decoration: none;
            color: black;
            font-weight: bold;
        }
        .btn-home:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>

    <h2 style="text-align:center;">메모 목록</h2>

    <!-- 검색 폼 추가 -->
    <form action="${pageContext.request.contextPath}/memo/search" method="get" style="text-align: center; margin-bottom: 20px;">
        <input type="text" name="title" placeholder="제목 검색" required>
        <button type="submit">검색</button>
    </form>

    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
            <th>수정일</th>
        </tr>

        <%
            if (memoList != null && !memoList.isEmpty()) {
                for (Memo memo : memoList) {
        %>
            <tr>
                <td><%= memo.getMemoNo() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/viewMemo?no=<%= memo.getMemoNo() %>">
                        <%= memo.getMemoTitle() %>
                    </a>
                </td>
                <td><%= memo.getCreateDate() %></td>
                <td><%= memo.getModifyDate() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="4">조회된 메모가 없습니다.</td>
            </tr>
        <%
            }
        %>
    </table>

    <a href="<%= request.getContextPath() %>/" class="btn-home"> 메인으로 돌아가기</a>

</body>
</html>