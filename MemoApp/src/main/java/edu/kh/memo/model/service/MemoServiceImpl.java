package edu.kh.memo.model.service;

import edu.kh.memo.model.dao.MemoDAO;
import edu.kh.memo.model.dao.MemoDAOImpl;
import edu.kh.memo.model.dto.Memo;

import java.sql.Connection;
import java.util.List;
import static edu.kh.memo.common.JDBCTemplate.*;

public class MemoServiceImpl implements MemoService {

    private MemoDAO dao = new MemoDAOImpl();

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
}