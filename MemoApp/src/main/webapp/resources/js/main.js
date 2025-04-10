/**
 * @author: 박민서, 
 * description: 회원가입, 로그인
 */

// 회원가입 --> (안준성 comment) : 로그인 코드? 회원가입 코드? 회원가입 코드는 signup.js에서 작성됨


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


 	}
});




