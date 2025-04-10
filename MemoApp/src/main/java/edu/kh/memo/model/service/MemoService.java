package edu.kh.memo.model.service;
import edu.kh.memo.model.dto.Memo;
import java.util.List;

public interface MemoService {

// 메모 삭제 서비스
	int memoDelete(int memoNo) throws Exception;
	
	Memo memoDetail(int memoNo);

	int memoUpdate(int memoNo, String title, String detail);
    List<Memo> searchMemoByTitle(String title) throws Exception;   // 제목으로 검색 (여러 개 가능)
    Memo selectMemoByNo(int memoNo) throws Exception;              // 번호로 상세 조회
        List<Memo> selectAllMemo() throws Exception;
}