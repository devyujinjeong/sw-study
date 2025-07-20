package com.dbwls.section01.intro;

public class Application2 {
    public static void main(String[] args) {
        /* 람다식 활용을 위한 내부 인터페이스 관리 기법*/
        // 내부에 선언된 인터페이스는 참조 연산자(.)를 통해서 선언
        OuterInterface.Sum sum = (int x, int y) -> x+y;
        OuterInterface.Minus minus = (int x, int y) -> x-y;
        OuterInterface.Multiple multiple = (int x, int y) -> x*y;
        OuterInterface.Divide divide = (int x, int y) -> x/y;

        System.out.println(sum.sumTwoNumber(10,30));
        System.out.println(minus.minusTwoNumber(40,10));
        System.out.println(multiple.multipleTwoNumber(3,2));
        System.out.println(divide.divideTwoNumber(40,10));
    }
}
