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
import java.util.List;

@WebServlet("/main") // 루트 요청 매핑 // 명하 main 추가
public class MainServlet extends HttpServlet {

    private MemoService service = new MemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Memo> memoList = service.selectAllMemo(); // 메모 목록 조회
            request.setAttribute("memos", memoList);       // requestScope에 담기
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}