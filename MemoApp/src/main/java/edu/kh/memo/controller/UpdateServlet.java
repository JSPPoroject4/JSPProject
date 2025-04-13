package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memo/update")
public class UpdateServlet extends HttpServlet{

	// 수정 화면 전환 GET 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 신명하
		try {
			
			// 수정 화면에는 기존의 제목, 상세내용이
			// input, textarea에 채워져있는 상태여야한다!
			// -> 수정 전 제목/내용 조회 == 상세조회 서비스 재호출
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			MemoService service = new MemoServiceImpl();

			Memo memo = service.memoDetail(memoNo);
			
			if(memo == null) {
				// 메인페이지 redirect
				resp.sendRedirect("${pageContext.request.contextPath}/main");
				return;
			}
			
			// request scope에 memo 객체 세팅
			req.setAttribute("memo", memo);
			
			// 요청발송자를 통해 forward 
			req.getRequestDispatcher("/WEB-INF/views/update.jsp")
			.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	/*
	 * 요청 주소가 같을 때
	 * 데이터 전달(제출) 방식이 다르면(GET/POST)
	 * 하나의 서블릿클래스에서 각각의 메서드(doGet() / doPost()) 를 
	 * 만들어 처리할 수 있다!
	 * 
	 * */
	
	// 할 일 제목/내용 수정 POST 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = null; // 변수 선언을 메서드 시작 부분으로 이동
		String message = null; // 변수 선언을 메서드 시작 부분으로 이동
		
		try {

			// 전달받은 파라미터 얻어오기 (제목, 상세내용, memoNo)
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));

			MemoService service = new MemoServiceImpl();
			int result = service.memoUpdate(memoNo, title, detail);

			// 메시지 view memo 로 전달
			if(result > 0) {
			    message = "수정 되었습니다";

			    // 메모 다시 조회해서
			    Memo memo = service.selectMemoByNo(memoNo);

			    req.setAttribute("message", message);
			    req.setAttribute("memo", memo); // 이게 핵심!

			    req.getRequestDispatcher("/WEB-INF/views/viewMemo.jsp").forward(req, resp);
			    return;
			} else { // 실패
				url = req.getContextPath() + "/memo/update?memoNo=" + memoNo;
				message = "수정 실패";
			}

			// session 객체에 속성 추가 (성공 시에는 더 이상 필요 없음)
			req.getSession().setAttribute("message", message);

			// redirect 는 Get 방식 요청 (성공 시에는 더 이상 필요 없음)
			resp.sendRedirect(url);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 필요하다면 finally 블록에 자원 해제 코드를 작성
		}
	} // doPost 메서드 닫는 중괄호

} // UpdateServlet 클래스 닫는 중괄호