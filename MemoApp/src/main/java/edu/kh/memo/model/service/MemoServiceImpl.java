package edu.kh.memo.model.service;

import static edu.kh.memo.common.JDBCTemplate.*; // 명하 위치 바꿈

import java.sql.Connection;
import edu.kh.memo.model.dto.Memo;
import java.util.List;

import edu.kh.memo.model.dao.MemoDAO; // 명하 위치 바꿈
import edu.kh.memo.model.dao.MemoDAOImpl; // 명하 위치 바꿈

public class MemoServiceImpl implements MemoService {

	private MemoDAO dao = new MemoDAOImpl();
	
	
	@Override
	public Memo memoDetail(int memoNo) {

		return null;
	}

	@Override
	public int memoUpdate(int memoNo, String title, String detail) {

		return 0;
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

	@Override
	public List<Memo> selectMemoList(Long memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

