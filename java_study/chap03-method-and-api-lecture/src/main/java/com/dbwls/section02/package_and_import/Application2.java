package com.dbwls.section02.package_and_import;

import com.dbwls.section01.method.Calculator;
import static com.dbwls.section01.method.Calculator.max;

/* 패키지가 다른 곳에서는 import를 한다. */
public class Application2 {
    public static void main(String[] args) {
        /* 클래스명은 원래 패키지명을 포함하고 있으며
        * 다른 패키지에 존재하는 클래스를 사용하는 경우 풀 클래스명을 사용해야 한다.*/
        Calculator calculator = new Calculator();
        System.out.println(calculator.min(10,20));

        /* static 메서드의 경우 import static 구문을 활용해서 클래스명을 생략하고 호출할 수 있다.*/
        System.out.println(Calculator.max(20,30));
        System.out.println(max(20,30));

    }
}
