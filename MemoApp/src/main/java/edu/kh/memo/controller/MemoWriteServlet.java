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

    // 로긴 멤버 속성 변환 김동준 수정
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Object loginMember = session.getAttribute("loginMember");

        // 데이터 타입 확인
        if (loginMember instanceof Member) {
            Member member = (Member) loginMember;

            String title = request.getParameter("title");
            String content = request.getParameter("content");

            Memo memo = new Memo();
            memo.setMemoTitle(title);
            memo.setMemoContent(content);
            memo.setMemberNo(member.getMemberNo());

            try {
                int result = service.insertMemo(memo);
                if (result > 0) {
                    response.sendRedirect(request.getContextPath() + "/memo/list");
                    
                } else {
                    request.setAttribute("errorMessage", "메모 작성에 실패했습니다.");
                    request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "메모 작성 중 오류 발생");
                request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
            }
            // 회원 정보 없을때 에러 작성 김동준 수정
        } else { 
            System.err.println("Session type mismatch: " + (loginMember != null ? loginMember.getClass().getName() : "null"));
            request.setAttribute("errorMessage", "로그인이 필요합니다. 올바른 회원 정보가 세션에 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
            return; // 메서드를 종료하여 더 이상 진행되지 않도록 방지
        }
    }
}
    