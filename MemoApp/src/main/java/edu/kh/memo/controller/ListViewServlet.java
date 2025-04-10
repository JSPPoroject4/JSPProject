package edu.kh.memo.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 목록 보기 서블릿
@WebServlet("/viewlist")
public class ListViewServlet extends HttpServlet {

	private final MemoService service = new MemoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			List<Memo> memoList = service.selectAllMemo();

			req.setAttribute("memoList", memoList);

			req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "메모 목록 조회 중 오류 발생");
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
		}
	}
}