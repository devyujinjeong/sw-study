package com.dbwls.chap01lifecycle.section02.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

/* @WebServlet: 서블릿을 서블릿 컨테이너에 등록
* value 속성 : 서블릿 매핑
* */

// 현재 어노테이션으로 설정한 경우가 더 우선순위가 높기 때문에 먼저 생성자와 init 메소드가 호출
@WebServlet(value = "/annotation-lifecycle",loadOnStartup = 1)
public class LifeCycleTest extends HttpServlet {

    public LifeCycleTest() {
        System.out.println("Annotation 매핑 생성자 호출");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Annotation 매핑 init 메소드 호출");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Annotation 매핑 service 메소드 호출");
    }

    @Override
    public void destroy() {
        System.out.println("Annotation 매핑 destroy 메소드 호출");
    }
}
