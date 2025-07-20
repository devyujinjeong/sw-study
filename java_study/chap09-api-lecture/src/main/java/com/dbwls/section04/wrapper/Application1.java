package com.dbwls.section04.wrapper;

public class Application1 {
    public static void main(String[] args) {
        /* Wrapper 클래스 사용법을 이해할 수 있다. */
        int num = 127;

        /* Wrapper 클래스 생성자는 1.9버전부터 Deprecated 되었다. */
//        Integer num1 = new Integer(num);

        /* Boxing : int -> Integer */
        Integer num1 = Integer.valueOf(num);

        /* Auto Boxing */
        Integer num2 = num;
//
        /* unboxing : Integer -> int */
        int num3 = num1.intValue();

        /* Auto UnBoxing */
        int num4 = num1;

        /* Integer.valueOf() 메소드가 byte 범위의 숫자는 캐싱 처리하고 있음*/
        System.out.println(num1==num2); // Intger, Integer 주소 값 비교
        System.out.println(num2==num3); // Intger ,int 값 비교
        System.out.println(num3==num4); // int, int 값 비교

        /* 인스턴스의 값 비교는 항상  equals() 메소드를 활용한다. */

    }
}
