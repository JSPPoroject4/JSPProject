/**
 * @author: 박민서
 * description: 회원가입, 로그인
 */

// 회원가입

const form = document.querySelector("#signupForm"); 

form.addEventListener('submit', function (e) {
  e.preventDefault();
const id = document.getElementById('id').value.trim();
const pw = document.getElementById('pw').value.trim();
const nickname = document.getElementById('nickname').value.trim();

// 입력되지 않았다면
if (id === "" || pw === "" || nickname === "") {
  alert("모든 값을 입력해주세요!");
  return;
}

// 로그아웃
const logout = document.querySelector("#logout");
if (logout) {
  logout.addEventListener("click", () => {
    location.href = "/logout";
});

const addForm = document.querySelector("#addForm");
const title = document.querySelector("{name=title}");

addForm.addEventListener("submit", (e) => {

  const input = title.value.trim();

  if (input.length === 0) {
    e.preventDefault();

    alert("제목을 입력해주세요!");
    title.focus();

 }
}});