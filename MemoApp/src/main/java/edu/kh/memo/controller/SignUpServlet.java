package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.service.SignUpService;
import edu.kh.memo.model.service.SignUpServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MemoApp/signup")
public class SignUpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SignUpService service = new SignUpServiceImpl();
			
			//int no = req.getParameter("")
			String id = req.getParameter("id"); //id = id
			String pw = req.getParameter("pw"); //pw = pw
			String nickname = req.getParameter("nickname");
			
			int result = service.signUp( id, pw, nickname);
			
			String message = null;
			if(result > 0) message ="추가 성공";
			else message="추가실패";
			//5. 기존 req를 사용할 수 없기 떄문에
			//session을 이용해서 message를 세팅
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			
			//6. 메인페이지로 redirect(재요청)
			
			//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/fr/Signin_forward_result.jsp");
			//req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);// TODO :나중에 signup.jsp를 따로 만들면 파일명 바꿀것!!
			
			resp.sendRedirect("/");
			
			// 3) HttpServletRequest / Response 두 객체를 요청 위임(forward)할 JSP에게 넘기기
			//dispatcher.forward(req, resp);
		}catch(java.sql.SQLIntegrityConstraintViolationException e) { 
			// 중복된 ID로 회원가입을 시도했을떄 무결성 위반 Exception 발생
			System.out.println("무결성 위반 Exception 발생" );
			HttpSession session = req.getSession();
			session.setAttribute("message", "이미 존재하는 아이디입니다!");
			
			resp.sendRedirect("/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
