package edu.kh.memo.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream inputStream = JDBCTemplate.class.getClassLoader().getResourceAsStream("xml/driver.xml");
            prop.loadFromXML(inputStream);

            String driverClassName = prop.getProperty("driver");
            Class.forName(driverClassName);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = prop.getProperty("url");
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        return DriverManager.getConnection(url, userName, password);
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(java.sql.Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(java.sql.ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}