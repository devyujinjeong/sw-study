package com.dbwls.section03.dto;

public class Application {
    public static void main(String[] args) {
        /* 데이터를 추상화하는 기법을 이해하고 이를 사용하여 프로그래밍화 할 수 있다. */

        /* DTO(Data Transfer Object) : 계층 간의 데이터 전달 용도로 사용되는 클래스
        * 캡슐화의 형태 */

        MemberDTO member = new MemberDTO();
        member.setNumber(1);
        member.setName("홍길동");
        member.setAge(20);
        member.setGender('남');
        member.setHeight(180.5);
        member.setWeight(80.6);
        member.setActivated(true);

        System.out.println("회원번호 : " + member.getNumber());
        System.out.println("회원명 : " + member.getName());
        System.out.println("나이 : " + member.getAge());
        System.out.println("성별 : " + member.getGender());
        System.out.println("키 : " + member.getHeight());
        System.out.println("몸무게 : " + member.getWeight());
        System.out.println("회원활성화상태 : " + member.isActivated());


    }
}
