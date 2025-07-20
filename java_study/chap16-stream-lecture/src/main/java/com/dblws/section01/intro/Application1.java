package com.dblws.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        /* Stream에 대해 이해하고 사용할 수 있다. */
        List<String> list = new ArrayList<>(
                Arrays.asList("hello", "stream", "world")
        );

        /* 1. Iterator 사용하기 */
        /* 특정 요소를 찾기 위해 iterator or foreach등을 활용할 수 있다. */
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("stream")){
                System.out.println("걸러낸 값 : " + str);
            }
        }

        /* 2. Stream 활용하기 */
        list.stream()
                // predicate : 반환 값이 boolean인 경우
                // "stream"과 list에 있는 값이 같다면
                .filter("stream"::equals)
                // consumer 타입을 전달 받음
                .forEach(str -> System.out.println("걸러낸 값 : " + str));

    }
}
