package edu.kh.memo.model.service;

import edu.kh.memo.model.dao.MemoDAO;
import edu.kh.memo.model.dao.MemoDAOImpl;

import java.sql.Connection;

import edu.kh.memo.model.dto.Memo;

public class MemoServiceImpl implements MemoService {

	private MemoDAO dao = new MemoDAOImpl();
	
	
	@Override
	public Memo memoDetail(int memoNo) {

		return null;
	}

	@Override
	public int memoUpdate(int memoNo, String title, String detail) {

		return 0;
	}
	
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

