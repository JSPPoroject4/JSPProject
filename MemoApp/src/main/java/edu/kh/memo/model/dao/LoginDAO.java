package edu.kh.memo.model.dao;

import java.sql.Connection;

public interface LoginDAO {
	public int Login(Connection conn,  String id, String pw)throws Exception
}
