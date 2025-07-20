package com.dbwls.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /* SqlSessionFactory : 애플리케이션이 실행 되는 동안 존재해야 하며 여러 차례 다시 빌드하지
    * 않는 것이 좋다. 즉, singletone 패턴을 활용하는 것이 가장 좋다. */
    private static SqlSessionFactory sqlSessionFactory;

    // 한 번의 요청 당 1개의 SqlSession 객체가 필요하므로 필요시 호출할 메소드
    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null){
            String resource = "mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                /* SqlSessionFactoryBuilder: SqlSessionFactory 생성 후 유지할 필요가 없으므로
                * 메소드 스코프로 생성하면 된다.*/
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* SqlSession
        * openSession을 false로 설정한다는 것은 수동 커밋으로 설정한다는 의미 */
        return sqlSessionFactory.openSession(false);
    }
}
