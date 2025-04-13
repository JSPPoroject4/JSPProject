package edu.kh.memo.model.service;

import static edu.kh.memo.common.JDBCTemplate.*; // 명하 위치 바꿈

import java.sql.Connection;

import edu.kh.memo.model.dto.Member;
import edu.kh.memo.model.dto.Memo;
import java.util.List;

import edu.kh.memo.model.dao.MemoDAO; // 명하 위치 바꿈
import edu.kh.memo.model.dao.MemoDAOImpl; // 명하 위치 바꿈

public class MemoServiceImpl implements MemoService {

	private MemoDAO dao = new MemoDAOImpl();
	
	// 메모 상세보기 추가
	@Override
	public Memo memoDetail(int memoNo) throws Exception {
		Connection conn = getConnection();
		Memo memo = dao.selectMemoByNo(conn, memoNo); // MemoDAOImpl의 selectMemoByNo 메서드 활용
		close(conn);
		return memo;
	}
	// 업데이트 수정 김동준
	@Override
	public int memoUpdate(int memoNo, String title, String detail) throws Exception {
		Connection conn = getConnection();
		int result = 0;

		try {
			result = dao.memoUpdate(conn, memoNo, title, detail);
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} finally {
			close(conn);
		}

		return result;
	}
	
	// 삭제
	
	@Override
	public int memoDelete(int memoNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.memoDelete(conn, memoNo);
		// memoNo 는 commit 대상 아니어서 삭제
		if(result > 0) commit(conn);
		else			rollback(conn);
		
						close(conn);
		
		return result;
	}

    @Override
    public List<Memo> searchMemoByTitle(String title) throws Exception {
        Connection conn = getConnection();
        List<Memo> memoList = dao.searchMemoByTitle(conn, title);
        close(conn);
        return memoList;
    }

    @Override
    public Memo selectMemoByNo(int memoNo) throws Exception {
        Connection conn = getConnection();
        Memo memo = dao.selectMemoByNo(conn, memoNo);
        close(conn);
        return memo;
    }
    
    @Override
    public List<Memo> selectAllMemo() throws Exception {
        Connection conn = getConnection();
        List<Memo> list = dao.selectAllMemo(conn);
        close(conn);
        return list;
    }
    // 멤버별 메모 보기 구현 김동준
	@Override
	public List<Memo> selectMemoList(Long memberNo) throws Exception {
		Connection conn = getConnection();
		List<Memo> memoList = dao.selectMemoList(conn, memberNo); // MemoDAOImpl의 메서드 호출
		close(conn);
		return memoList;
	} // 김동준 수정
	
	@Override
	public int insertMemo(Memo memo) throws Exception {
	    Connection conn = getConnection();
	    int result = 0;

	    try {
	        result = dao.insertMemo(conn, memo); // DAO 호출
	        if(result > 0) commit(conn);
	        else rollback(conn);
	    } catch(Exception e) {
	        e.printStackTrace();
	        rollback(conn);
	        throw e;
	    } finally {
	        close(conn);
	    }

	    return result;
	}
    @Override
    public Member login(String memberId, String memberPw) throws Exception {
        Connection conn = getConnection();
        Member loginMember = dao.login(conn, memberId, memberPw); // MemoDAO의 login 메서드 호출
        close(conn);
        return loginMember;
    }
}

