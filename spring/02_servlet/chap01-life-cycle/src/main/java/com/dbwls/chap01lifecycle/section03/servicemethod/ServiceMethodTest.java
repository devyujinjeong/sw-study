package com.dbwls.chap01lifecycle.section03.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/request-service")
public class ServiceMethodTest extends HttpServlet {
    @Override
    // 요청 방식이 어떤건지에 따라 맞게 사용할 수 있게 하는 것
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String httpMethod = req.getMethod();
        System.out.println("httpMethod : " + httpMethod);

        // GET 방식으로 요청이 들어오는 경우
        if("GET".equals(httpMethod)){
            doGet(req,resp);
        // POST 방식으로 요청이 들어오는 경우
        }else if("POST".equals(httpMethod)) {
            doPost(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 방식의 요청 처리 메소드");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 방식의 요청 처리 메소드");
    }
}
