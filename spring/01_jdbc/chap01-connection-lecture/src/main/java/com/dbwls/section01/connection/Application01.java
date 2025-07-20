package com.dbwls.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application01 {
    public static void main(String[] args) {
        // 1. 자바와 데이터 베이스를 연결하는 Connection 객체를 만들거야.
        // 2. 이 때, connection 객체는 드라이버 매니저의 getConnection을 이용해 만든다.
        // 3. DB 연결 정보가 잘못 작성 된다면 SQLException이 발생할 수 있고,
        // 4. 이것은 checked Exception이기 때문에 반드시 예외 처리를 해줘야 한다.
        Connection con = null;
        try {
            /* DB 연결 정보가 잘못 작성 된 경우 Connection 객체 생성이 불가능하므로
            * SQLException이 발생할 수 있다. 그렇기 때문에 반드시 try-catch 문으로 감싸줘야 한다.  */
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", "practice", "practice");
            System.out.println("con = " + con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
