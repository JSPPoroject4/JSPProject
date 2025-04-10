package edu.kh.memo.model.service;
import edu.kh.memo.model.dto.Memo;

public interface MemoService {

// 메모 삭제 서비스
	int memoDelete(int memoNo) throws Exception;
	
	Memo memoDetail(int memoNo);

	int memoUpdate(int memoNo, String title, String detail);




}
