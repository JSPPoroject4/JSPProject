package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Memo/delete")
public class DeleteServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			try {
				
				int memoNo = Integer.parseInt("memoNo");
					
				MemoService servie = new MemoServiceImpl();
				int result = service.todoDelete(memoNo);
				
				HttpSession session = req.getSession();
				
				if(result>0)message = "메모가 삭제되었습니다.";
				else		message = "존재하는 메모가 없습니다.";
						
			
				session.setAttribute("message", message);
				
				resp.sendRedirect("/");
				
				
			
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
	
	
	
}
