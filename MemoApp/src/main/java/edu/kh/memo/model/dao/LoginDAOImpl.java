package edu.kh.memo.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class LoginDAOImpl implements LoginDAO{
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	public LoginDAOImpl() {
		try {
			String filePath = SignUpDAO.class.getResource("/xml/sql.xml")
					.getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		
		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외 발생!");// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int Login(Connection conn, String id, String pw) throws Exception {
		String sql = prop.getProperty("searchByMemberId");
		pstmt = conn.prepareStatement(sql);
		//pstmt.setString(1, no);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		result = pstmt.executeQuery();
		System.out.println(result>0);
	}
	
}
