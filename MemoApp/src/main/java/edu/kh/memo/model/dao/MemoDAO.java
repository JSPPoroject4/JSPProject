package edu.kh.memo.model.dao;

import edu.kh.memo.model.dto.Memo;

import java.sql.Connection;
import java.util.List;

public interface MemoDAO {
    List<Memo> searchMemoByTitle(Connection conn, String title);
    Memo selectMemoByNo(Connection conn, int memoNo);
        List<Memo> selectAllMemo(Connection conn) throws Exception;
}