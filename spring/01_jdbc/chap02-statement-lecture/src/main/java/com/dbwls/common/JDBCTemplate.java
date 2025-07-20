package com.dbwls.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/* 이후에 JDBC 관련 코드들이 반복적으로 호출 될 예정이므로 Util용으로 JDBCTemplate 클랫스를 작성한다. */
public class JDBCTemplate {
    // 이 메소드는 생성해서 반환해주는 역할만 하는 메소드인 것이므로, close()는 이 메소드 안에서 호출하지 않는다.
    public static Connection getConnection(){
        Properties properties = new Properties();
        Connection con;
        try {
            properties.load(
                    new FileReader(
                            "src/main/java/com/dbwls/config/jdbc-config.properties"
                    )
            );

            String url = properties.getProperty("url");
            con = DriverManager.getConnection(url, properties);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    /* Conncetion을 닫는 개념은 별도의 메소드로 분리하고 실제 닫는 시점은 Service 계층에서 진행 */
    public static void close(Connection con){
        try {
            // con이 null이 아니고, 닫혀있지 않은 상태인 경우 닫겠다!
            if(con!=null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt){
        try {
            // con이 null이 아니고, 닫혀있지 않은 상태인 경우 닫겠다!
            if(stmt!=null && !stmt.isClosed()) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){
        try {
            // con이 null이 아니고, 닫혀있지 않은 상태인 경우 닫겠다!
            if(rset!=null && !rset.isClosed()) rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
