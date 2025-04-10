<div class="search-bar">
    <form action="search" method="get">
        <input type="text" name="title" placeholder="메모 제목을 검색하세요" id="searchTitle" required>
        <button type="submit">검색</button>
    </form>

    <c:if test="${not empty errorMsg}">
        <p class="error-msg">${errorMsg}</p>
    </c:if>
</div>