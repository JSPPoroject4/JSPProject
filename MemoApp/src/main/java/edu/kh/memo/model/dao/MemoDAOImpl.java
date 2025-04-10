package edu.kh.memo.model.dao;

import edu.kh.memo.model.dto.Memo;
import edu.kh.memo.common.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemoDAOImpl implements MemoDAO {
	
	@Override
	public List<Memo> selectAllMemo(Connection conn) throws Exception {
	    List<Memo> list = new ArrayList<>();
	    String sql = "SELECT MEMO_NO, MEMO_TITLE, CREATE_DATE, MODIFY_DATE FROM MEMO ORDER BY CREATE_DATE DESC";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            Memo memo = new Memo();
	            memo.setMemoNo(rs.getLong("MEMO_NO"));
	            memo.setMemoTitle(rs.getString("MEMO_TITLE"));
	            memo.setCreateDate(rs.getTimestamp("CREATE_DATE"));
	            memo.setModifyDate(rs.getTimestamp("MODIFY_DATE"));

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