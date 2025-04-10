package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.service.SignUpService;
import edu.kh.memo.model.service.SignUpServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginService service = new LoginServiceServiceImpl();
		
		//int no = req.getParameter("")
		String id = req.getParameter("id-signup"); //id-signup = id
		String pw = req.getParameter("pw-signup"); //pw-signup = pw
		
		try {
			
			int result = service.Login( id, pw);
			
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
		}catch(Exception e) {}
		
		
	}
}
