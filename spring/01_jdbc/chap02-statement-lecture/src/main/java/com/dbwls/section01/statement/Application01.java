package com.dbwls.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.dbwls.common.JDBCTemplate.close;
import static com.dbwls.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            /* Statement: 쿼리를 운반하고 그 결과를 반환하는 객체*/
            stmt = con.createStatement();
            /* ResultSet : Statement 객체를 통해 조회 처리된 결과를 다루는 객체 */
            rset = stmt.executeQuery("SELECT * FROM employee");

            while(rset.next()){ // 결과 행의 존재 여부를 확인
                // 타입을 맞춰서 꺼내주기
                System.out.print(rset.getString("emp_name") + " ");
                System.out.println(rset.getInt("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 자원은 항상 반납해야 한다!
            close(rset);
            close(stmt);
            close(con);
        }

    }
}
