package com.dbwls.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.dbwls.common.JDBCTemplate.close;

public class MenuRepository {

    public int updateMenu(Connection con, Menu modifyMenu) {
        PreparedStatement pstmt = null;
        Properties prop = new Properties();
        int result = 0;

        try {
            prop.loadFromXML(
                    new FileInputStream(
                            "src/main/java/com/dbwls/mapper/MenuMapper.xml"
                    )
            );

            String sql = prop.getProperty("updateMenu");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt(2, modifyMenu.getMenuPrice());
            pstmt.setInt(3, modifyMenu.getMenuCode());

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}