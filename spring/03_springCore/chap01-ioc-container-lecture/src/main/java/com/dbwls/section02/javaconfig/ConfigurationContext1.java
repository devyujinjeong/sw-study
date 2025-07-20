package com.dbwls.section02.javaconfig;

import com.dbwls.common.MemberDTO;
import org.springframework.context.annotation.Bean;

public class ConfigurationContext1 {
    /* @Bean 사용 시 name 속성을 생략하면 메소드명이 bean 이름이 된다.
    * 만약 이것을 원치 않는다면, name 속성을 적어주면 된다.  */
    @Bean(name = "member")
    public MemberDTO getMember(){
        return new MemberDTO(1,"user01","pass01", "홍길동");
    }
}
