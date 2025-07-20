package com.dbwls.chap05cookiesessionlecture.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
// cookie가 import 됨
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cookie")
public class CookieHandler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        /* 1. 쿠키 생성 */
        // firstName, lastName 이라는 쿠키를 생성
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        /* 2. 쿠키 만료 시간 설정 */
        // 만약 쿠키의 만료 시간을 설정하지 않으면, 브라우저 동작 동안에 유지된다.
        firstNameCookie.setMaxAge(60 * 60 * 24);
        lastNameCookie.setMaxAge(60 * 60 * 24);

        /* 3. 응답 헤더에 쿠키를 담음 */
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        /* 4. redirect 방식으로 요청을 보낸다. */
        resp.sendRedirect("cookie-redirect");
    }
}
