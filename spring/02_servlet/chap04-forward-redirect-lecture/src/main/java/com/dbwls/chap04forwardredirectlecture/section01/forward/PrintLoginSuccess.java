package com.dbwls.chap04forwardredirectlecture.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/print")
public class PrintLoginSuccess extends HttpServlet {
    // 그래서 무엇을...? 오버라이딩? 메소드는 보존! dopost를 똑같이 사용

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* forward 된 servlet에서도 요청 방식이 그대로 유지된다. post -> post
        * 또한 전달 된 req,resp의 모든 정보를 이용해 새로운 req,resp를 깊은 복사를 통해 만들어
        * 전달하므로 데이터가 그대로 유지된다. */
        String userName = (String)req.getAttribute("userName");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>"+userName+"님 환영합니다.<h1>");
        out.flush();
        out.close();
    }
}
