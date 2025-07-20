package com.dbwls.common;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int sequence; //회원번호
    private String name; //이름
    private String phone; //휴대폰번호
    private String email; //이메일
//    private Account personalAccount = new Account(); 이런식으로 직접 하지 않음
    private Account personalAccount; //개인계좌
}
