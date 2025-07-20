package com.dbwls.section02.javaconfig;

import com.dbwls.common.Account;
import com.dbwls.common.MemberDTO;
import com.dbwls.common.PersonalAccount;
import org.springframework.context.annotation.Bean;

public class ContextConfiguration {
    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20, "123-456-7890");
    }

    /* bean 등록에 사용 된 메소드를 호출해 의존성 주입을 처리할 수 있다. */
    @Bean
    public MemberDTO memberGenerator(){
        /* 1. 생성자 주입 */
        /*return new MemberDTO(
                1,"홍길동","010-1234-5678",
                "hong@gmail.com",accountGenerator());*/

        /* 2. setter 주입 */
        MemberDTO member = new MemberDTO();
        member.setPersonalAccount(accountGenerator());
        return member;
    }
}
