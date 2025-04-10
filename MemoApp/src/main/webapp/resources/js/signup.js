/*name 어트리뷰트들에 signup 과 login의 구분 추가*/ 
const id = document.querySelector("[name=id-signup]");

const pw = document.querySelector("[name=pw-signup]");

const pwCheck = document.querySelector("[name=pw-check-signup]");

const nickname = document.querySelector("[name=nickname-signup]");

const signUpForm = document.querySelector("#signup-form");


signUpForm.addEventListener("submit",(e) => {

    //e : 이벤트객체
    //제목 입력된 값 가져와서 양쪽 공백 제거

    if(id.value === ""){
        // form 태그 제출 이벤트 막기
        console.log("아이디를 입력해주세요!")
        e.preventDefault();
        alert("아이디를 입력해주세요!!");
        id.focus();
    }

    else if(pw.value === ""){
        // form 태그 제출 이벤트 막기
        console.log("비밀번호를 입력해주세요!")
        e.preventDefault();
        alert("비밀번호를 입력해주세요!!");
        pw.focus();
        
    }
    else if(pwCheck.value === ""){
        // form 태그 제출 이벤트 막기
        console.log("비밀번호 확인란을 입력해주세요!")
        e.preventDefault();
        alert("비밀번호 확인란을 입력해주세요!!");
       
        pwCheck.focus();
    }
    else if(pw.value !==pwCheck.value ){

        e.preventDefault();
        console.log("비번확인이 일치하지 않습니다!!");
        alert("비번확인이 일치하지 않습니다!!");
    }
    else if(nickname.value === "" ){

        e.preventDefault();
        console.log("닉네임을 입력하세요!!");
        alert("닉네임을 입력하세요!!");
        nickname.focus();
    }
});

if(id != null) {
	
	id.addEventListener("change", (e) => {
	
	
	    
	
	})
}