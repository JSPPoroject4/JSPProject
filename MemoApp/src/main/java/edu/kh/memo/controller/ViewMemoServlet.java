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
//위치 수정 김동준
@WebServlet("/memoApp/viewNotes")
public class ViewMemoServlet extends HttpServlet {

    private final MemoService memoService = new MemoServiceImpl();
//req,resp 수정
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long memberNo = (Long) session.getAttribute("loginMemberNo");

        System.out.println("ViewMemoServlet - memberNo from session: " + memberNo); // 추가된 로그

        if (memberNo == null) {
            resp.getWriter().println("Error: User is not logged in.");
            return;
        }
        // 문제 추적, 초기화
        List<Memo> memoList = null;
		try {
			memoList = memoService.selectMemoList(memberNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("ViewMemoServlet - memoList size: " + memoList.size()); // 추가된 로그
        //req, resp 수정
        req.setAttribute("memos", memoList); 
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}