package com.dbwls.section02.userexception;

import com.dbwls.section02.userexception.exception.MoneyNegativeException;
import com.dbwls.section02.userexception.exception.NotEnoughMoneyException;
import com.dbwls.section02.userexception.exception.PriceNegativeException;

public class Application2 {
    public static void main(String[] args) {
        /* 사용자 정의 예외 클래스를 사용할 수 있다. */
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
            // 정상 수행
            exceptionTest.checkEnoughMoney(30000, 50000);
            // 상품 가격이 음수
//            exceptionTest.checkEnoughMoney(-30000, 50000);
            // 가진 돈이 음수
//            exceptionTest.checkEnoughMoney(30000, -50000);
            // 상품 가격보다 가진 돈이 적은 경우
            exceptionTest.checkEnoughMoney(50000, 30000);

            /* | : 동일한 레벨의 다른 타입의 예외를 하나의 catch 블록에서 처리할 수 있다.
             * 단, 상위 타입의 Exception과 하위 타입의 Exception이 함께 서술 될 수 없다.
             *  */
        } catch (PriceNegativeException | MoneyNegativeException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("프로그램을 종료합니다.");
    }
}