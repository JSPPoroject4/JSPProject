<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>메모 상세</title>
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
        <!-- 삭제/수정 버튼 및 스크립트 생성 -->
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
    <!-- 스크립트 끝 김동준 -->
</body>
</html>