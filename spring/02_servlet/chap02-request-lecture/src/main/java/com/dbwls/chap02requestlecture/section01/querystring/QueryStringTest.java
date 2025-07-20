package com.dbwls.chap02requestlecture.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/querystring")
public class QueryStringTest extends HttpServlet {
    /* 서블릿이 매핑 된 주소로 GET 방식의 요청이 발생하면 doGet 메소드가 호출된다. */
    /* 참고로 doGet과 doPost 메소드는 개발자가 오버라이딩 하지 않으면 지원하지 않는 메소드라고 에러가 발생하게 코드가 짜있다.*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter 메소드로 추출 할 수 있다.
        * 인자로 input 태그의 name 속성 값을 문자열 형태로 전달한다.
        * 모든 input 태그의 값을 hashmap으로 관리하고 있으므로 원하는 값을 찾기 위해
        * key 역할을 할 문자열이 필요하기 때문이다.
        * */

        /* getParameter의 반환 타입은 String이므로 다른 형식은 parsing이 필요하다. */
        // HttpServletRequest 객체로부터 요청시 전달한 값을 getParmeter 메소드로 추출함
        // 지금 키 역할을 하는 문자열을 통해서 값을 추출하고 있음
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
