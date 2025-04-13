<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.kh.memo.model.dto.Memo" %>
<%
    List<Memo> memoList = (List<Memo>) request.getAttribute("memoList");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메모 목록</title>
    <link rel="stylesheet" href="/MemoApp/src/main/webapp/resources/css/list.css">
   
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

    <a href="<%= request.getContextPath() %>/" class="btn-home">🏠 메인으로 돌아가기</a>


    
    
</body>
</html>