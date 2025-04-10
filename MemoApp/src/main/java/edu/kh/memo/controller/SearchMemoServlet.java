package edu.kh.memo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import edu.kh.memo.model.dto.Memo;

import java.io.IOException;
import java.util.List;

@WebServlet("/memo/search")
public class SearchMemoServlet extends HttpServlet {

    private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String title = req.getParameter("title");
        try {
            List<Memo> memoList = service.searchMemoByTitle(title);
            req.setAttribute("memoList", memoList);
            req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "검색 중 문제가 발생했습니다.");
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        }
    }
}