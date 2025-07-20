package com.dbwls.section01.intro;

// 틀을 제공!! '구현해주세요!' 라는 목적이다.
// 함수형 인터페이스 : 내부에 하나의 추상 메소드가 선언 된 인터페이스로
// 람다식의 타깃이 될 수 있다.

// 체크를 해주는 용도!!
@FunctionalInterface
public interface Calculator {
    // 이미 추상메소드로 선언된 것임
    int sumTwoNumber(int a, int b);

//    int minusTwoNumber(int a, int b);
}
