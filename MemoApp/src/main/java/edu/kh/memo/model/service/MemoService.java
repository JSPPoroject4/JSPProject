	package edu.kh.memo.model.service;
	
	import java.util.List;

import edu.kh.memo.model.dto.Member;
import edu.kh.memo.model.dto.Memo;
	
	public interface MemoService {
	
	    List<Memo> selectAllMemo() throws Exception;
	
	    Memo selectMemoByNo(int memoNo) throws Exception;
	
	    List<Memo> searchMemoByTitle(String title) throws Exception;
	
	    int memoDelete(int memoNo) throws Exception;
	
	    int memoUpdate(int memoNo, String title, String detail) throws Exception;
	
	    Memo memoDetail(int memoNo) throws Exception;
	
	    List<Memo> selectMemoList(Long memberNo) throws Exception;
	
	    int insertMemo(Memo memo) throws Exception; // ✅ 이 부분이 핵심!
	    
	    Member login(String memberId, String memberPw) throws Exception; // login 메서드 추가 김동준

	}
