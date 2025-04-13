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
import java.util.List;
// 동준 이름 변경 및 리스트 뷰 서블릿으로 변경
@WebServlet("/memo/list")
public class MemoListServlet extends HttpServlet {
private MemoService service = new MemoServiceImpl(); // MemoService 객체 생성 김동준 수정

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            // 메모 목록 데이터 가져오기
            List<Memo> memoList = service.selectAllMemo();

            // JSP에 전달
            request.setAttribute("memoList", memoList);
            request.getRequestDispatcher("/WEB-INF/views/memoList.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "메모 목록을 가져오는 중 오류 발생");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}