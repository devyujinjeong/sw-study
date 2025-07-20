package com.dbwls.chap04forwardredirectlecture.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/forward")
public class ReceiveInformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        /* id, pwd에 해당하는 user의 정보를 조회한 뒤 반환 되는 비즈니스 로직이 수행 됐다고 가정하고
        * 'xxx님 환영합니다' 와 같은 메세지를 출력 화면으로 응답한다.
        * */
        req.setAttribute("userName", "홍길동"); // attribute가 보존됨

        /* 비즈니스 로직 수행과 응답 화면 생성을 분리하기 위해 다른 서블릿으로 위임 (forward) */
        // 응답할 화면의 로직은 다른 서블릿에서 사용하고 싶음

        // "print"로 권한을 위임하기!!!
        RequestDispatcher rd = req.getRequestDispatcher("print");
        // 여기에서 사용한 req,resp를 그대로 전해주는 것!
        rd.forward(req,resp);

    }
}
