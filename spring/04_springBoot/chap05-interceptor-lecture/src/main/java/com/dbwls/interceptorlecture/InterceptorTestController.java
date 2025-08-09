package com.dbwls.interceptorlecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorTestController {

    /* 이 stopwatch라고 들어오는 경로에 interceptor를 적용하고 싶음*/
    @GetMapping("/stopwatch")
    public String stopwatch() throws InterruptedException {
        System.out.println("Handler Method 호출 시점");
        Thread.sleep(1000); // 무언가 수행하는 상황을 상정하는 코드
        return "resultㅊ";
    }
}

