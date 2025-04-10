package edu.kh.memo.model.dao;

import java.sql.Connection;

public interface SignUpDAO {
	//int no는 트리거를 이용해 자동생성
	public int signUp(Connection conn,  String id, String pw, String nickname)throws Exception;
		
	
}
