package com.dblws.section02.uses.subsection02.intermediate;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application4 {
    public static void main(String[] args) {
        /* 스트림의 중계 연산 중 sorted에 대해 이해하고 사용할 수 있다. */
        /* 1. 오름차순 정렬 */
        List<Integer> integerList1 =
                IntStream.of(5,10,99,7,1,50)
                        .boxed()
                        .sorted()
                        .toList();


        /* 2. 내림차순 정렬*/
        List<Integer> integerList2 =
                IntStream.of(1,11,2,9,8,3,10)
                        .boxed()
                        .sorted((o1, o2) -> o2 - o1)
                        .toList();

        System.out.println(integerList1);
        System.out.println(integerList2);
    }
}
