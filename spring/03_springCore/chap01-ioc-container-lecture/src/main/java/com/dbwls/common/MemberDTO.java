package com.dbwls.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
// POJO 가장 기본적인 자바 객체라고 생각하면 됨
public class MemberDTO {
    private int sequence; //회원번호
    private String id; //아이디
    private String pwd; //비밀번호
    private String name; //이름
}