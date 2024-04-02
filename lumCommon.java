package 올룸골룸.VO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class lumCommon {
    //    드라이버와 연결하기 위한 정보
    final static String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String ORACLE_ID = "SCOTT";
    final static String ORACLE_PW = "TIGER";
    final static String ORACLE_DRV = "oracle.jdbc.driver.OracleDriver";


    // JAVA와 ORACLE 연결하는 부분
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //드라이브
            Class.forName(ORACLE_DRV);
            // URL, ID , PASSWORD를 보고 CONNECT
            conn = DriverManager.getConnection(ORACLE_URL, ORACLE_ID, ORACLE_PW);
            System.out.println("Connection 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    //CONNECTION에 대한 CLOSE
    public static void close(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection 해제 성공");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //STATEMENT에 대한 CLOSE문
    public static void close(Statement stmt) {
        try {
            if(stmt != null && !stmt.isClosed()) {
                stmt.close();
                System.out.println("Statement 해제 성공");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //RESULTESET에 대한 CLOSE문
    public static void close(ResultSet rset) {
        try {
            if(rset != null && !rset.isClosed()) {
                rset.close();
                System.out.println("Result set 해제 성공");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
