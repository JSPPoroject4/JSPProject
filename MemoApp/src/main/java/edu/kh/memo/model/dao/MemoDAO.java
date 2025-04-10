package edu.kh.memo.model.dao;

import java.sql.Connection;

public interface MemoDAO {
	
	// 삭제 (List 있다고 가정)
	int memoDelete(Connection conn, int memoNo) throws Exception;
	
}
