package com.dbwls.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 해당 어노테이션이 적용 된 클래스의 @ExceptionHandler는 전역적으로 기능한다.
* 즉, 여러 개의 컨트롤러에서 발생하는 예외를 일괄적으로 처리하기 위해 사용되는 것이다.
* 이렇게 사용하면, 모든 컨트롤러에서 공통적으로 발생하는 예외를 한 곳에서 처리할 수 있어 코드의 중복을 방지할 수 있다. */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e){
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException e, Model model){
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }

    /* 모든 타입의 Exception에 대응하기 위해 상위 타입으로 선언 된 핸들러 작성 */
    /* 위에 구체적인 exception이 아니라면 여기에 작성한 exception이 발생함*/
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e){
        return "error/default";
    }
}
