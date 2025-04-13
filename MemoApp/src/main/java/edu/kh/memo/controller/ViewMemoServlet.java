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
import edu.kh.memo.model.dto.Member; // 멤버 임포트 추가

//위치 수정 김동준
@WebServlet("/viewMemo")
public class ViewMemoServlet extends HttpServlet {

    private final MemoService memoService = new MemoServiceImpl();
//req,resp 수정
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember"); // Member 객체 가져오기
        Long memberNo = null;
        if (loginMember != null) {
            memberNo = loginMember.getMemberNo(); // Member 객체에서 회원 번호 추출
        }

        System.out.println("ViewMemoServlet - memberNo from session: " + memberNo); // 추가된 로그

        if (memberNo == null) {
            resp.getWriter().println("Error: User is not logged in.");
            return;
        }
        // 메모 상세 보기 수정 김동준
        // 1. 요청 파라미터에서 메모 번호(no) 얻어오기
        String memoNoStr = req.getParameter("no");
        if (memoNoStr == null || memoNoStr.isEmpty()) {
            resp.getWriter().println("Error: Memo number is missing.");
            return;
        }
        int memoNo = Integer.parseInt(memoNoStr);

        // 2. MemoService를 이용하여 특정 메모 상세 정보 조회
        Memo memo = null;
        try {
            memo = memoService.selectMemoByNo(memoNo); // 이 메서드를 사용
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: Failed to retrieve memo details.");
            return;
        }

        // 3. 조회된 메모 정보를 request scope에 저장
        req.setAttribute("memo", memo);

        // 4. 메모 상세 정보를 보여줄 JSP 페이지로 forward
        String path = "/WEB-INF/views/viewMemo.jsp"; // 새로운 JSP 파일 경로
        req.getRequestDispatcher(path).forward(req, resp);
    }
}