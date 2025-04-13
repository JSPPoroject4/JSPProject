package edu.kh.memo.controller;

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

import java.io.IOException;
import java.util.List;

@WebServlet("/memo/list")
public class MemoListServlet extends HttpServlet {
    private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Memo> memoList = service.selectAllMemo();
            request.setAttribute("memoList", memoList);
            request.getRequestDispatcher("/WEB-INF/views/memoList.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "메모 목록을 가져오는 중 오류 발생");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            HttpSession session = request.getSession();
            Member loginMember = (Member) session.getAttribute("loginMember");

            if (loginMember != null) {
                // Long 타입으로 변경
                Long memberNo = loginMember.getMemberNo();

                Memo memo = new Memo();
                memo.setMemoTitle(title);
                memo.setMemoContent(content);
                memo.setMemberNo(memberNo); // 작성자 회원 번호 설정

                int result = service.insertMemo(memo);

                if (result > 0) {
                    response.sendRedirect(request.getContextPath() + "/memo/list");
                } else {
                    request.setAttribute("errorMessage", "메모 작성 중 오류 발생");
                    request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "로그인 후 이용해주세요.");
                request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "메모 작성 중 오류 발생");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}