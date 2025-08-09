package com.dbwls.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/* Controller 레벨의 Exception 처리 */
@Controller
public class ExceptionHandlerController {
    // 여기에서 /controller-null 이 요청을 받아들였을 때, 밑에 메소드가 실행된다.
    // 이 메소드를 통해 NullPointerException이 발생하면 밑에 핸들러가 예외를 핸들링 하는 것이다.
    @GetMapping("/controller-null")
    public String nullPointerExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0)); // 의도적으로 NullPointerException 발생 시킴

        return "/";
    }

    @GetMapping("/controller-user")
    public String userExceptionTest() throws MemberRegistException{
        boolean check = true;
        if(check){
            throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다.");
        }
        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        // Exception 객체가 가지고 있는 정보를 가져오는게 가능함
        System.out.println("지역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException e, Model model){
        System.out.println("지역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }
}
