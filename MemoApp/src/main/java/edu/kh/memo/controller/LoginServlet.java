package edu.kh.memo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import edu.kh.memo.model.dto.Member; // 임포트 김동준 수정
import edu.kh.memo.model.service.MemoService; // 임포트 김동준 수정
import edu.kh.memo.model.service.MemoServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	 private MemoService service = new MemoServiceImpl(); // MemoService 객체 생성 김동준 수정

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("id-login");
		String userPw = req.getParameter("pw-login");
		
		// service 요청 (userId/ userPw가 둘 다 맞는 회원이 있는지 DB에서 조회)
		// 결과값 반환 (User & null)
		
		try {
			Member loginMember = service.login(userId, userPw); // service.login() 호출 김동준 수정

			if (loginMember != null) {
				// 로그인 성공
				HttpSession session = req.getSession();
				session.setAttribute("loginMember", loginMember); // Member 객체를 세션에 저장
				System.out.println("LoginServlet - loginMember type: " + loginMember.getClass().getName());
				resp.sendRedirect(req.getContextPath() + "/main");
			} else {
				// 로그인 실패
				req.setAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
				req.getRequestDispatcher("/WEB-INF/views/loginFail.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "로그인 중 오류 발생");
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
		}
	}
		
		
		
		// session scope에 로그인한 회원의 정보를 저장!
		// 브라우저 종료 및 세션 만료 외에는
		// 모든 페이지에서 로그인정보를 이용할 수 있게끔 해야함
		//HttpSession session = req.getSession();
		//session.setAttribute("loginMember", userId);
		
        // 리디렉션 경로 수정 김동준
        //resp.sendRedirect(req.getContextPath() + "/main");
	}

