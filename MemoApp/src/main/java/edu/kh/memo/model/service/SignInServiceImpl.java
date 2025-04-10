package edu.kh.memo.model.service;

import static edu.kh.memo.common.JDBCTemplate.close;
import static edu.kh.memo.common.JDBCTemplate.commit;
import static edu.kh.memo.common.JDBCTemplate.getConnection;
import static edu.kh.memo.common.JDBCTemplate.rollback;

import java.sql.Connection;

import edu.kh.memo.model.dao.SignInDAO;
import edu.kh.memo.model.dao.SignInDAOImpl;


public class SignInServiceImpl implements SignInService {
	private SignInDAO dao = new SignInDAOImpl();
	
	@Override
	public int signIn( String id, String pw, String nickname) throws Exception {
		Connection conn = getConnection();
		System.out.println("connection : " + conn.toString());	
		
		int result = dao.signIn(conn, id, pw, nickname);
		//트랜잭션 제어처리 -> DML(INSERT/UPDATE/DELETE)
		if(result > 0) 	commit(conn);
		else 			rollback(conn);
		
			close(conn);
		
		return result;
		
	}
	
}
