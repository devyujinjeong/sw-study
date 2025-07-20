package com.dbwls.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// MainController를 만들어서 /나 main이 여기로 오도록하기!
// 처음 접속하는 페이지를 지정해줌
public class MainController {
    @RequestMapping({"/","/main"})
    public String mainPage(){
        return "main";
    }
}
