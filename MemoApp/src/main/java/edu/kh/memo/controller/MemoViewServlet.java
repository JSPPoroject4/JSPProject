package edu.kh.memo.controller;

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
@WebServlet("/memo/view")
public class MemoViewServlet extends HttpServlet {

    private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            int memoNo = Integer.parseInt(request.getParameter("no")); // 파라미터 받기
            Memo memo = service.selectMemoByNo(memoNo);                // 서비스 호출

            request.setAttribute("memo", memo); // requestScope에 담기
            request.getRequestDispatcher("/WEB-INF/views/memo/view.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "메모 상세 조회 중 오류 발생");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}