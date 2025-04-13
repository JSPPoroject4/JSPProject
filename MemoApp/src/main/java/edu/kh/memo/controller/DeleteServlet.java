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

@WebServlet("/memo/delete")
public class DeleteServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession session = req.getSession();
			String message = null;
			String redirectURL = "http://localhost:8080/MemoApp/main";

			try {
				// 1. 파라미터 얻어오기
				String memoNoStr = req.getParameter("memoNo"); // 요청 파라미터 이름은 "memoNo"
				int memoNo = Integer.parseInt(memoNoStr);

				// 2. 서비스 객체 생성 및 메서드 호출
				MemoService service = new MemoServiceImpl();
				int result = service.memoDelete(memoNo);

				// 3. 메시지 설정
				if(result > 0) {
					message = "메모가 삭제되었습니다.";
				} else {
					message = "존재하지 않는 메모이거나 삭제에 실패했습니다.";
				}


			} catch (NumberFormatException e) {
				// memoNo 파라미터가 없거나 숫자가 아닌 경우
				e.printStackTrace();
				message = "잘못된 메모 번호입니다.";
			} catch (Exception e) {
				// 그 외 예외 발생 시
				e.printStackTrace();
				message = "메모 삭제 중 오류가 발생했습니다.";
			} finally {
				// 4. Session에 메시지 설정 및 리다이렉트
				session.setAttribute("message", message);
				resp.sendRedirect(redirectURL);
			}

		}
}