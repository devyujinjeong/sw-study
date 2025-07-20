package com.dbwls.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* Dispatcher Servlet은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
* 그 과정은 컨트롤러 클래스의 핸들러 메소드에 선언 된 다양한 @RequestMapping 설정 내용에 따른다. */
@Controller
public class MethodMappingTestController {

    /* 1. http 방식을 미지정 */
    @RequestMapping("/menu/register")
    public String menuRegister(Model model){
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");
        return "mappingResult";
    }

    /* 2. http method 방식 지정 */
    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String menuModify(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 수정 핸들러 메소드 호출");
        return "mappingResult";
    }


    /* 3. http method 전용 어노테이션 */
    @GetMapping("/menu/delete")
    public String getMenuDelete(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 수정 핸들러 메소드 호출");
        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postMenuDelete(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 수정 핸들러 메소드 호출");
        return "mappingResult";
    }
}

