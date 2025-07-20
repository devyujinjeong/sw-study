package com.dbwls.section02.javaconfig;

import com.dbwls.common.Account;
import com.dbwls.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemberDTO member = applicationContext.getBean("memberGenerator", MemberDTO.class);
        System.out.println(member.getPersonalAccount().getBalance());

        Account account = applicationContext.getBean("accountGenerator", Account.class);
        System.out.println(account.withDraw(1000));
    }
}
