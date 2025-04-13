package edu.kh.memo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;

import java.io.IOException;
// 메모 상세 보기 
// 통채로 수정 김동준
@WebServlet("/memo/view")
public class MemoViewServlet extends HttpServlet {

    private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int memoNo = Integer.parseInt(req.getParameter("memoNo"));

        // 초기화
        Memo memo = null;
		try {
			memo = service.selectMemoByNo(memoNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("memo", memo);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/viewMemo.jsp");
        dispatcher.forward(req, resp);
    }
}