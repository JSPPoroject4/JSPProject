package edu.kh.memo.model.dao;

import java.sql.Connection;
import java.util.List;
import edu.kh.memo.model.dto.Memo;

public interface MemoDAO {
	
	// 삭제 (List 있다고 가정)
	List<Memo> selectAllMemo(Connection conn) throws Exception; // 명하 위치바꿈
	
	int memoDelete(Connection conn, int memoNo) throws Exception;
  
	List<Memo> searchMemoByTitle(Connection conn, String title);
    
	Memo selectMemoByNo(Connection conn, int memoNo);
       
	
}
