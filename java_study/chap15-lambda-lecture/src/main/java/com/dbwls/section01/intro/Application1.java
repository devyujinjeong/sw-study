package com.dbwls.section01.intro;

public class Application1 {
    public static void main(String[] args) {
        /* 인터페이스에 정의 된 추상 메소드를 활용하는 방법 */

        /* 1. 인터페이스를 상속 받은 클래스를 정의해 기능을 완성한 뒤에 사용한다. */
        // 재사용을 해야 하는 경우에는 클래스를 정의해서 만든다.
        Calculator c1 = new CalculatorImpl();
        System.out.println(c1.sumTwoNumber(10,30));

        /* 2. 익명 클래스를 사용해서 기능을 구현한다. */
        // 재사용이 필요 없이 딱 1번만 사용하는 경우에는 익명 클래스를 사용한다.
        Calculator c2 = new Calculator() {
            @Override
            public int sumTwoNumber(int a, int b) {
                return a+b;
            }
        };
        System.out.println(c2.sumTwoNumber(10,30));

        /* 3. 람다식을 이용한 방법 */
        Calculator c3 = (int a, int b) -> a+b;
        System.out.println(c3.sumTwoNumber(30,40));
    }
}
