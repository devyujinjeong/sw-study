package com.dbwls.chap04forwardredirectlecture.section02.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/othersite")
public class OtherSiteRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 이후 naver로 redirect");
        // 리다이렉트 방식으로 보냄! 다른 사이트로 이동!
        resp.sendRedirect("https://www.naver.com/");
    }
}
