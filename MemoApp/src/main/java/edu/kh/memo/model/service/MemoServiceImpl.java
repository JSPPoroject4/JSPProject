package edu.kh.memo.model.service;

import java.sql.Connection;

import edu.kh.memo.model.dao.MemoDAO;
import edu.kh.memo.model.dao.MemoDAOImpl;

public class MemoServiceImpl implements MemoService{
	
	private MemoDAO dao = new MemoDAOImpl();
	
	
	
	// 삭제
	
	@Override
	public int memoDelete(int memoNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.memoDelete(conn, memoNo);
		
		if(result > 0) commit(conn, memoNo);
		else			rollback(conn);
		
						close(conn);
		
		return result;
	}



	}
}
