package com.dbwls.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/menu")
public class RequestMappingTestController {

    @RequestMapping
    public String otherRequest(Model model){
        model.addAttribute(
                "message",
                "menu 요청이긴 하지만 다른 기능은 아직 준비 되지 않음"
        );
        return "mappingResult";
    }
}

