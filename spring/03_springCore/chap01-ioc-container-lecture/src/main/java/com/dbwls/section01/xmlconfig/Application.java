package com.dbwls.section01.xmlconfig;

import com.dbwls.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* GenericXmlApplicationContext 클래스를 이용해 ApplicationContext를 생성한다.
        * 생성자에 XML 설정 메타 정보를 인자로 전달한다.  */
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // 여기에서 핵심은 우리가 직접 memberDTO 객체를 생성하지 않은 것!
        // 1. Bean의 이름을 통해서 가져옴 :Bean의 name은 중복되면 안됨
//        MemberDTO member = (MemberDTO)applicationContext.getBean("member");
        // 2. Bean의 타입을 통해서 가져옴
//        MemberDTO member = applicationContext.getBean(MemberDTO.class);
        // 3. Bean의 이름과 타입을 통해 가져옴
        // MemberDTO 타입이 여러 개가 있다면 이렇게 2가지를 전달해서 사용하면 됨
        MemberDTO member = applicationContext.getBean("member",MemberDTO.class);

        System.out.println(member);
    }
}
