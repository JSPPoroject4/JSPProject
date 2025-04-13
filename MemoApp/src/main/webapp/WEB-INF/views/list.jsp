<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <h2 style="text-align:center;">📋 메모 목록</h2>

    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
            <th>수정일</th>
            <th>작성자</th> <th>삭제</th>
        </tr>

        <c:choose>
            <c:when test="${empty memoList}">
                <tr>
                    <td colspan="6">조회된 메모가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="memo" items="${memoList}">
                    <tr>
                        <td>${memo.memoNo}</td>
                        <td>
                            <a href="<%= request.getContextPath() %>/viewMemo?no=${memo.memoNo}">
                                ${memo.memoTitle}
                            </a>
                        </td>
                        <td>${memo.createDate}</td>
                        <td>${memo.modifyDate}</td>
                        <td>${memo.member.nickname}</td> <td>
                            <a href="<%= request.getContextPath() %>/memo/delete?memoNo=${memo.memoNo}" onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>

    <a href="<%= request.getContextPath() %>/" class="btn-home">🏠 메인으로 돌아가기</a>

</body>
</html>