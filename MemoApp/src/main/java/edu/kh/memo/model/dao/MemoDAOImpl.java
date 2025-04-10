package edu.kh.memo.model.dao;

import java.sql.Connection;

public class MemoDAOImpl {

	
	
	// 삭제 DAO
	@Override
	
	public int todoDelete(Connection conn, int todoNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("memoDelete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
}
