package com.dbwls.springdatajpa.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 메인 페이지로
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public String main() {

        return "main/main";
    }

}