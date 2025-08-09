package com.dbwls.interceptorlecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /* main 페이지로 진입할 수 있게 경로를 설정함 */
    @RequestMapping({"/","/main"})
    public String mainPage(){
        return "main";
    }

}
