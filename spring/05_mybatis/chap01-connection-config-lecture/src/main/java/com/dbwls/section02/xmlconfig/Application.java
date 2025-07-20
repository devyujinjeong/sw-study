package com.dbwls.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/* MyBatis를 사용해 현재 날짜를 조회 */
public class Application {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml"; // mybatis 설정 파일 (section01에서 configuration 부분)
        try {
            // getResourceAsStream : mybatis-config.xml 파일을 클래스 패스에서 찾아서 InputStream으로 읽어오는 역할
            // 파일을 읽어오는 것이므로 InputStream 사용하기
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory
                    = new SqlSessionFactoryBuilder().build(inputStream);
            // 수동 커밋으로 변경하기
            SqlSession sqlSession = sqlSessionFactory.openSession(false);

            // selectOne : 조회 결과가 1행인 경우 사용하는 메소드
            // mapper.xml 파일의 namespace와 select 태그의 id를 통해 수행 구문을 찾아옴
            java.util.Date now = sqlSession.selectOne("mapper.selectDate");
            System.out.println("now = " + now);

            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}