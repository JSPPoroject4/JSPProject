package edu.kh.memo.model.service;

import jakarta.servlet.http.HttpSession;

public interface LoginService {
	public int Login( String id,String  pw) throws Exception;
}
