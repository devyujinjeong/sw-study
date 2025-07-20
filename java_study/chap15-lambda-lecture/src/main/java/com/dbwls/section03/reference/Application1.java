package com.dbwls.section03.reference;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Application1 {
    public static void main(String[] args) {
        /* 메소드 참조에 대해 이해하고 사용할 수 있다. */
        /* 1. Function 이용하기 */
        BiFunction<String, String, Boolean> biFunction;

        String str1 = "METHOD";
        String str2 = "method";

        /* 람다식 사용 버전 */
        biFunction = (x,y) -> x.equals(y);
        Boolean result = biFunction.apply(str1, str2);
        System.out.println("result = " + result);

        /* 메소드 참조 버전 */
        biFunction = String::equals;
        result = biFunction.apply(str1, str2);
        System.out.println("result = " + result);

        /* 2. Predicate 이용하기 */
        Predicate<String> isEqualsToSample;
        String sample = "hello world";

        /* 람다식 사용 버전*/
        isEqualsToSample = s->s.equals(sample);
        result = isEqualsToSample.test("Hello World");
        System.out.println("result : " + result);

        /* 메소드 참조 버전 */
        isEqualsToSample = sample::equals;
        result = isEqualsToSample.test("Hello World");
        System.out.println("result = " + result);
    }
}
