package com.dbwls.chap02requestlecture.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/formdata")
public class FormDataTest extends HttpServlet {
    /* 서블릿이 매핑 된 주소로 POST 방식의 요청이 발생하면 doPost 메소드가 호출된다. */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");
        /* checkbox는 다중으로 값을 입력 받을 수 있으므로 문자열 배열로 전달된다.  */
        String[] hobbies = req.getParameterValues("hobbies");


        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("birthday = " + birthday);
        System.out.println("gender = " + gender);
        System.out.println("national = " + national);
        System.out.println("hobbies = " + Arrays.toString(hobbies));

    }
}
