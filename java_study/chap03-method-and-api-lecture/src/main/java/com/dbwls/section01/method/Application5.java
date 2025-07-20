package com.dbwls.section01.method;

public class Application5 {
    public static void main(String[] args) {
        Application5 application5 = new Application5();
        System.out.println(application5.plus(10,20));

        /* static 메서드 호출*/
        /* 대문자인 것 주의하! */
        System.out.println(Application5.minus(10,20));
        /* 동일 클래스 내에서 static 메서드 호출 시에는 클래스명 생략도 가능*/
        System.out.println(minus(30,10));
    }

    public int plus(int a, int b){
        return a+b;
    }

    public static int minus(int a, int b){
        return a-b;
    }
}
