package com.dbwls.section02.javaconfig;

import com.dbwls.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // 1. ApplicationContext 생성하기
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ConfigurationContext1.class);

        // 2. member라는 name의 bean을 가져오기
        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);
        System.out.println(member);
    }
}
