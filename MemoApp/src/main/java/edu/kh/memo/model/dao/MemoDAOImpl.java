package edu.kh.memo.model.dao;

import java.sql.Connection;
import edu.kh.memo.model.dto.Memo;
//static 추가
import static edu.kh.memo.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import edu.kh.memo.model.dto.Memo;

public class MemoDAOImpl implements MemoDAO {
    
	// JDBC 객체 참조 변수 선언 + Properties 참조 변수 선언  // 명하 작성
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// TodoListDAOImpl 생성자 /xml/sql.xml 경로 읽어오기
	public MemoDAOImpl() {
	// TodoListDAOImpl 객체가 생성 될 때( Service 단에서 new 연산자를 통해 객체화 될 때)
	// sql.xml 파일의 내용을 읽어와 Properties prop 객체에 K:V 세팅
		
		try {
			String filePath = MemoDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();
		}
		
	}
	// 명하 여기까지 작
	

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
            
            pstmt.setInt(1, memoNo); // 명하 todoNo -> memoNo로 바꿈

            
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
