package edu.kh.memo.model.dao;

import static edu.kh.memo.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;



public class SignInDAOImpl implements SignInDAO{
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	public SignInDAOImpl() {
		try {
			String filePath = SignInDAO.class.getResource("/xml/sql.xml")
					.getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외 발생!");// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int signIn(Connection conn, String id, String pw, String nickname) throws Exception {
		
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signin");
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, no);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, nickname);
			result = pstmt.executeUpdate();
			System.out.println(result>0);
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
