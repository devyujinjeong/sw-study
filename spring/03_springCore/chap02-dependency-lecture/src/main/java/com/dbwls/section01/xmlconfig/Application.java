package com.dbwls.section01.xmlconfig;

import com.dbwls.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // 1.GenericXmlApplicationContext, 즉 XML 파일을 읽어오는 클래스를 이용해 applicationContext 객체를 생성한다.
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // 2. bean 객체를 가져온다.
        // account라는 bean을 주입했기 때문에, 거기에 있는 메소드를 사용하는 것이다.
        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);
        System.out.println(member.getPersonalAccount().getBalance());
    }
}
