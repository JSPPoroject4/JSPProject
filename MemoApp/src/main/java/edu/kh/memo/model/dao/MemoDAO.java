package edu.kh.memo.model.dao;

import java.sql.Connection;
import java.util.List;
import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.model.dto.Member; // Member DTO import 추가


public interface MemoDAO {
	
	// 전체 메모 조회
	List<Memo> selectAllMemo(Connection conn) throws Exception;
	
	// 메모 삭제
	int memoDelete(Connection conn, int memoNo) throws Exception;
  
	// 제목으로 메모 검색
	List<Memo> searchMemoByTitle(Connection conn, String title) throws Exception;
    
	// 메모 번호로 조회
	Memo selectMemoByNo(Connection conn, int memoNo) throws Exception;

	// 메모 삽입
	int insertMemo(Connection conn, Memo memo) throws Exception;
	
	// login 메서드 추가 김동준 수정
    Member login(Connection conn, String memberId, String memberPw) throws Exception; // login 메서드 추가

    // 셀렉트 메모 리스트 추가 김동준 수정
    List<Memo> selectMemoList(Connection conn, Long memberNo) throws Exception;
    
    //메모 업데이트 메서드 선언 김동준 수정
    int memoUpdate(Connection conn, int memoNo, String title, String detail) throws Exception;

	
}
