package com.dbwls.section03.delete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.dbwls.common.JDBCTemplate.close;

/* Repository 계층 : 내가 데이터 베이스에 어떤 것을 요청할지?
* DBMS를 통해 수행 되는 CRUD 작업 단위의 메소드를 정의 */
public class MenuRepository {
    public int deleteMenu(Connection con, int menuCode){
        PreparedStatement pstmt = null;
        Properties properties = new Properties();
        int result = 0;

        try {
            // xml에 있는 내용을 읽어와야 함
            properties.loadFromXML(new FileInputStream("src/main/java/com/dbwls/mapper/MenuMapper.xml"));
            String sql = properties.getProperty("deleteMenu");

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, menuCode);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}
