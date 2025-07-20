package com.dblws.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application2 {
    public static void main(String[] args) {
        /* 스트림 중계 연산 중 하나인 map에 대해 이해할 수 있다.
        * 중계 연산은 최종 연산 수행 전까지 여러 번 수행할 수 있으며
        * 먼저 일어난 중걔 연산의 결과가 파이프라인을 통해 다음 중계 연산으로 전달된다. */

        // 1~10까지의 숫자 중 짝수를 5배 해서 출력하기
        IntStream intStream = IntStream.range(1, 11);   // 1 ~ 10

        intStream.filter(i -> i % 2 == 0)               // 2, 4 ,6 ,8, 10
                .map(i -> i * 5)                        // 10, 20, 30, 40, 50
                .forEach(result -> System.out.print(result + " "));
    }
}
