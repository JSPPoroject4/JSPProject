<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 목록</title>
	<link rel="stylesheet" href="/MemoApp/resources/css/list.css">
    <style>
        header {
            text-align: center;
            margin-top: 30px;
        }

        header .logo { /* header h1 대신 .logo 클래스에 적용 */
            color: #3b73e8;
            font-size: 24px;
            font-weight: bold;
            margin: 0;
        }

        h2 {
            text-align: center;
            color: #3b73e8;
            margin-top: 40px;
            margin-bottom: 20px;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            border: 2px solid #3b73e8;
        }

        th, td {
            border: 1px solid #3b73e8;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f0f8ff; /* 연한 파란색 배경 */
            color: #3b73e8;
            font-weight: bold;
        }

        td a {
            color: #3b73e8;
            text-decoration: none;
        }

        td a:hover {
            text-decoration: underline;
        }

        .btn-home {
            display: block;
            width: 150px;
            margin: 30px auto;
            padding: 10px 20px;
            background-color: #3b73e8;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }

        .btn-home:hover {
            background-color: #2c5bb0;
        }
    </style>
</head>
<body>
    <header>
        <div class="logo">Memo</div>
    </header>

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