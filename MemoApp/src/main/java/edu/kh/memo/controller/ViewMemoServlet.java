package edu.kh.memo.controller;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewNotes")
public class ViewMemoServlet extends HttpServlet {

    private final MemoService memoService = new MemoServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long memberNo = (Long) session.getAttribute("loginMemberNo");

        System.out.println("ViewMemoServlet - memberNo from session: " + memberNo); // 추가된 로그

        if (memberNo == null) {
            response.getWriter().println("Error: User is not logged in.");
            return;
        }

        List<Memo> memoList = memoService.selectMemoList(memberNo);

        System.out.println("ViewMemoServlet - memoList size: " + memoList.size()); // 추가된 로그

        request.setAttribute("memos", memoList); 
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}