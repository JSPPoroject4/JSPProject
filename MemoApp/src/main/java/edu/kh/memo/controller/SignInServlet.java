package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.service.SignInService;
import edu.kh.memo.model.service.SignInServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SignInService service = new SignInServiceImpl();
			
			//int no = req.getParameter("")
			String id = req.getParameter("id"); //id = id
			String pw = req.getParameter("pw"); //pw = pw
			String nickname = req.getParameter("nickname");
			
			int result = service.signIn( id, pw, nickname);
			
			String message = null;
			if(result > 0) message ="추가 성공";
			else message="추가실패";
			//5. 기존 req를 사용할 수 없기 떄문에
			//session을 이용해서 message를 세팅
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			
			//6. 메인페이지로 redirect(재요청)
			
			resp.sendRedirect("/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
