/**
 * @author: 박민서
 * description: 회원가입, 로그인
 */
const form = document.querySelector("#signupForm");

form.addEventListener('submit', function (e) {
  e.preventDefault();

  const id = document.querySelector('[name="id"]').value.trim();
  const pw = document.querySelector('[name="pw"]').value.trim();
  const nickname = document.querySelector('[name="nickname"]').value.trim();  

  if (id === "" || pw === "" || nickname === "") {
    alert("모든 값을 입력해주세요!");
    return;
  }

  // 성공 시
  alert("회원가입이 성공적으로 완료되었습니다!");
  form.submit();

});

// 로그아웃 처리
const logout = document.querySelector("#logout");
if (logout) {
  logout.addEventListener("click", () => {
    location.href = "/logout";
  });
}

// 게시글 제목 입력 검사
const addForm = document.querySelector("#addForm");
const title = document.querySelector("[name='title']");

if (addForm) {
  addForm.addEventListener("submit", (e) => {
    const input = title.value.trim();

    if (input.length === 0) {
      e.preventDefault();

      alert("제목을 입력해주세요!");
      title.focus();
    }
  });
}
