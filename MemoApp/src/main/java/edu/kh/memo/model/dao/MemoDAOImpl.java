package edu.kh.memo.model.dao;
import java.sql.Connection;
import edu.kh.memo.model.dto.Memo;
//static 추가
import static edu.kh.memo.common.JDBCTemplate.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemoDAOImpl implements MemoDAO {
	// prop 선언
	private final Properties prop = new Properties();

    // 삭제 DAO
    @Override
    
    public int memoDelete(Connection conn, int memoNo) throws Exception {
    	//pstmt 선언
    	PreparedStatement pstmt = null;
        int result = 0;
        
        try {
            String sql = prop.getProperty("memoDelete");
            //pstmt 선언 수정 - 김동준
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, memoNo);
            
            result = pstmt.executeUpdate();
            
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    @Override
    public List<Memo> selectAllMemo(Connection conn) throws Exception {
        List<Memo> list = new ArrayList<>();
        String sql = prop.getProperty("selectAllMemos");

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Memo memo = new Memo();
                memo.setMemoNo(rs.getLong("MEMO_NO"));
                memo.setMemoTitle(rs.getString("MEMO_TITLE"));
                memo.setCreateDate(rs.getTimestamp("CREATE_DT"));
                memo.setModifyDate(rs.getTimestamp("MODIFY_DT"));

                list.add(memo);
            }
        }

        return list;
    }
    
    @Override
    public List<Memo> searchMemoByTitle(Connection conn, String title) {
        List<Memo> list = new ArrayList<>();
        String sql = "SELECT * FROM MEMO WHERE MEMO_TITLE LIKE ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + title + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Memo memo = Memo.builder()
                            .memoNo(rs.getLong("MEMO_NO"))
                            .memoTitle(rs.getString("MEMO_TITLE"))
                            .memoContent(rs.getString("MEMO_CONTENT"))
                            .createDate(rs.getDate("CREATE_DT"))
                            .modifyDate(rs.getDate("MODIFY_DT"))
                            .memberNo(rs.getLong("MEMBER_NO"))
                            .build();

                    list.add(memo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Memo selectMemoByNo(Connection conn, int memoNo) {
        Memo memo = null;
        String sql = "SELECT * FROM MEMO WHERE MEMO_NO = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, memoNo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    memo = Memo.builder()
                            .memoNo(rs.getLong("MEMO_NO"))
                            .memoTitle(rs.getString("MEMO_TITLE"))
                            .memoContent(rs.getString("MEMO_CONTENT"))
                            .createDate(rs.getDate("CREATE_DT"))
                            .modifyDate(rs.getDate("MODIFY_DT"))
                            .memberNo(rs.getLong("MEMBER_NO"))
                            .build();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return memo;
    }
    
}
