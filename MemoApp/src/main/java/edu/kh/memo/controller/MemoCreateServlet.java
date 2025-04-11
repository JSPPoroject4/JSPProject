package edu.kh.memo.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memo/write")
public class MemoCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 로그인 안 한 경우 메인으로 보냄
        if (req.getSession().getAttribute("loginMember") == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        // 메모 작성 페이지로 이동
        req.getRequestDispatcher("/WEB-INF/views/memo/write.jsp").forward(req, resp);
    }
}
