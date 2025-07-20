package com.dbwls.section03.proxy.subsection02.cglib;

import com.dbwls.section03.proxy.common.DbwlsStudent;
import com.dbwls.section03.proxy.common.Student;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {
        /* 2. CGLib Proxy 방식
        * Target Object 타입이 Class여도 가능하다.*/

        DbwlsStudent dbwlsStudent = new DbwlsStudent();
        Handler handler = new Handler(dbwlsStudent);

        DbwlsStudent proxy = (DbwlsStudent) Enhancer.create(DbwlsStudent.class, handler);
        proxy.study(12);
    }
}
