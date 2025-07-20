package com.dbwls.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    // 연결 저보들
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "swcamp";
    private static String PASSWORD = "swcamp";

    public static void main(String[] args) {
        // 1. DB 접속에 관한 환경 설정 정보를 가진 객체 : 기본 생성자를 제공하지 않음
        Environment environment = new Environment(
                "dev",  // 환경 정보 이름
                // JdbcTransactionFactory : 수동 커밋, ManagedTransactionFactory : 자동 커밋
                new JdbcTransactionFactory(),   // 트랜잭션 매니저 종류 (JDBC or MANAGED)
                new PooledDataSource(
                        DRIVER, URL, USER, PASSWORD
                )   // Connection Pool 사용 유무 (Pooled : 연결을 재사용 or UnPooled : 매번 새로운 연결)
        );

        // 2. 생성한 환경 설정 정보로 Mybatis 설정 객체 생성
        // myBatis 전역 설정 정보를 담고 있음
        // 즉 이 코드는 위에서 만든 enviornment를 MyBatis 설정에 적용하는 것이다.
        Configuration configuration = new Configuration(environment);

        // 3. 설정 객체에 Mapper 등록 : MyBatis가 어떤 SQL을 실행할지 알아야 하니깐!
        // Mapper 인터페이스를 SQL 실행 객체로 사용할 수 있게 설정
        configuration.addMapper(Mapper.class);

        /* SqlSession 객체를 만들기 위한 여정*/
        // 4. SqlSessionFactoryBuilder : SqlSessionFactory 타입의 하위 구현체 객체를 생성하기 위한 빌더 클래스
        // 5. SqlSessionFactory : SqlSession 객체 생성을 위한 팩토리 역할의 인터페이스
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        // 6. openSession : SqlSession 타입의 인터페이스를 반환하는 메소드
        // false : DML 수행 후 auto commit 옵션을 false로 지정 -> 수동 커밋 모드로 변경
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 7. mapper를 가져와서 sql을 실행!
        // getMapper : Configuration에 등록 된 Mapper의 구현체 반환
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        java.util.Date now = mapper.selectDate();
        System.out.println("now = " + now);

        // SqlSession 반납
        sqlSession.close();

    }
}
