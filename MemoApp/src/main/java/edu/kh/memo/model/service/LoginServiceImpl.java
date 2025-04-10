package edu.kh.memo.model.service;

import static edu.kh.memo.common.JDBCTemplate.close;
import static edu.kh.memo.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import edu.kh.memo.model.dao.LoginDAO;

public class LoginServiceImpl implements LoginService {
	private LoginDAO dao = new LoginDAOimpl();
	@Override
	public int Login(String id, String pw) throws Exception{
		Connection conn = getConnection();
		
		
		int result = dao.Login(conn, id, pw);
		// Login 에서 아이디가 존재한다는 값을 return 하는가?
		if(result > 0) 	//commit(conn);
		else 			//rollback(conn);
		
			close(conn);
		
		return result;
	}
	
}
