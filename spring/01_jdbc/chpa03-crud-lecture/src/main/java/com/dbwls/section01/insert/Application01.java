package com.dbwls.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.dbwls.common.JDBCTemplate.close;
import static com.dbwls.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into " +
                "tbl_menu(menu_name, menu_price, category_code, orderable_status) " +
                "values(?, ?, ?, ?)";

        int result = 0;

        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, "봉골레청국장");
            pstmt.setInt(2, 12000);
            pstmt.setInt(3, 4);
            pstmt.setString(4, "Y");

            // insert, update, delete 시에는 수행 된 행의 개수를 int로 반환
            // executeUpdate() 로 호출
            result = pstmt.executeUpdate();

            if(result > 0) {
                con.commit();
            } else {
                con.rollback();
            }

            System.out.println("insert 결과 : " + result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

    }
}