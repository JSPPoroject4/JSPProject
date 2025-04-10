package edu.kh.memo.controller;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/memo/viewMemo")
// 이름 맞게 수정
public class VieMemoSevlet extends HttpServlet {
    private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int memoNo = Integer.parseInt(request.getParameter("memoNo"));

        // 초기화
        Memo memo = null;
		try {
			memo = service.selectMemoByNo(memoNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("memo", memo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/viewMemo.jsp");
        dispatcher.forward(request, response);
    }
}