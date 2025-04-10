/**
 * @author: 박민서
 * description: 회원가입, 로그인
 */

// 회원가입


// 김동준 수정. 사인업 폼 괄호 및 쿼리셀렉터 수정
const form = document.querySelector("#signup-form");

form.addEventListener('submit', function (e) {
  const id = document.querySelector('input[name="id"]').value.trim();
  const pw = document.querySelector('input[name="pw"]').value.trim();
  const nickname = document.querySelector('input[name="nickname"]').value.trim();

  if (id === "" || pw === "" || nickname === "") {
    e.preventDefault();
    alert("모든 값을 입력해주세요!");
  }
});// 수정 끝
// 로그아웃
const logout = document.querySelector("#logout");

logout.addEventListener("click", () => {
  location.href = "/logout";
});

// 검색
const addForm = document.querySelector("#addForm");
const title = document.querySelector('input[name="title"]'); // 김동준 수정. title 선택자 수정

addForm.addEventListener("submit", (e) => {

  const input = title.value.trim();

  if (input.length === 0) {
    e.preventDefault();

    alert("제목을 입력해주세요!");
    title.focus();

 }});
 // 검색창
<div class="search-bar">
    <form action="search" method="get">
        <input type="text" name="title" placeholder="메모 제목을 검색하세요" id="searchTitle" required>
        <button type="submit">검색</button>
    </form>

    <c:if test="${not empty errorMsg}">
        <p class="error-msg">${errorMsg}</p>
    </c:if>
</div>
