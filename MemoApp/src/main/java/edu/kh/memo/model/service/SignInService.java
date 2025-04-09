package edu.kh.memo.model.service;

public interface SignInService {
	/**
	 * @param id
	 * @param pw
	 * @param nickname
	 * @return int 성공시 추가된 행의 개수 / 실패 시 0 반환
	 * @throws Exception
	 * 
	 * */
	public int signIn(String id, String pw, String nickname) throws Exception;
}
