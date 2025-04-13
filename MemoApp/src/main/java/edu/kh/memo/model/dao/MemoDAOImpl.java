package edu.kh.memo.model.dao;

import static edu.kh.memo.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

import edu.kh.memo.model.dto.Member;
import edu.kh.memo.model.dto.Memo;

public class MemoDAOImpl implements MemoDAO {

    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Properties prop;

    public MemoDAOImpl() {
        try {
            String filePath = MemoDAOImpl.class.getResource("/xml/sql.xml").getPath();
            prop = new Properties();
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (Exception e) {
            System.out.println("sql.xml 로드 중 예외 발생");
            e.printStackTrace();
        }
    }

    // ✅ insertMemo 구현부
    @Override
    public int insertMemo(Connection conn, Memo memo) throws Exception {
        int result = 0;
        PreparedStatement pstmt = null;

        try {
            String sql = prop.getProperty("insertMemo"); // sql.xml에서 읽음
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memo.getMemoTitle());
            pstmt.setString(2, memo.getMemoContent());
            pstmt.setLong(3, memo.getMemberNo());

            result = pstmt.executeUpdate();
        } finally {
            close(pstmt);
        }

        return result;
    }

    @Override
    public int memoDelete(Connection conn, int memoNo) throws Exception {
        int result = 0;
        PreparedStatement pstmt = null;

        try {
            String sql = prop.getProperty("memoDelete");
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
        	// DT-DATE 수정 김동준
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
            // DT-DATE 수정
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Memo memo = Memo.builder()
                            .memoNo(rs.getLong("MEMO_NO"))
                            .memoTitle(rs.getString("MEMO_TITLE"))
                            .memoContent(rs.getString("MEMO_CONTENT"))
                            .createDate(rs.getDate("CREATE_DATE"))
                            .modifyDate(rs.getDate("MODIFY_DATE"))
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
                            .createDate(rs.getDate("CREATE_DATE"))
                            .modifyDate(rs.getDate("MODIFY_DATE"))
                            .memberNo(rs.getLong("MEMBER_NO"))
                            .build();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return memo;
    }

	@Override // 로긴 멤버 추가. 
	public Member login(Connection conn, String memberId, String memberPw) throws Exception {
		Member loginMember = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = prop.getProperty("login"); // sql.xml에 login SQL 정의 필요

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, memberId);
	        pstmt.setString(2, memberPw);
	        rs = pstmt.executeQuery();

	        // 김동준 수정
	        if (rs.next()) {
                loginMember = new Member();
                loginMember.setMemberNo(rs.getLong("MEMBER_NO")); // 데이터베이스에서 MEMBER_NO 가져와 설정
                loginMember.setId(rs.getString("MEMBER_ID")); // 데이터베이스에서 MEMBER_ID 가져와 id에 설정
                loginMember.setPw(rs.getString("MEMBER_PW")); // 데이터베이스에서 MEMBER_PW 가져와 pw에 설정 (필요하다면)
            }

	    } finally {
	        close(rs);
	        close(pstmt);
	    }

	    return loginMember;
	}
	
}
