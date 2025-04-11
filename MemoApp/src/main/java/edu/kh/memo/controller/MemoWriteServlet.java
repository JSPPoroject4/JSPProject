package edu.kh.memo.controller;

import java.io.IOException;

import edu.kh.memo.model.dto.Member;
import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/memo")
public class MemoWriteServlet extends HttpServlet {

    private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // 메모 작성 화면 보여주기
    	request.getRequestDispatcher("/WEB-INF/views/write.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember");

        if (loginMember == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Memo memo = new Memo();
        memo.setMemoTitle(title);
        memo.setMemoContent(content);
        memo.setMemberNo(loginMember.getMemberNo());

        int result = 0;
        try {
            result = service.insertMemo(memo);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "메모 작성 중 오류 발생");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
            return;
        }

        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/memo/list");
        } else {
            request.setAttribute("errorMessage", "메모 작성에 실패했습니다.");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}
