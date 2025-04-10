package edu.kh.memo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.service.MemoService;
import edu.kh.memo.model.service.MemoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

		


@WebServlet("/main") // 루트 요청 매핑 // 명하 main 추가 // 합친거
public class MainServlet extends HttpServlet {

    private MemoService service = new MemoServiceImpl();

  	//왜 index.jsp에서 메인페이지 코드 작성하지 않고
	  // /main 요청을 처리하는 서블릿을 만들었는가?
	
	  // - Servlet(Back-End)에서 추가한(조회한) 데이터를 
	  // 메인페이지에서부터 사용할수 있게 하기 위해..
  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            List<Memo> memoList = service.selectAllMemo(); // 메모 목록 조회
            req.setAttribute("memos", memoList);       // requestScope에 담기
          	
            String path = "/WEB-INF/views/main.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			/*index에서 main으로 forwarding*/
          
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}