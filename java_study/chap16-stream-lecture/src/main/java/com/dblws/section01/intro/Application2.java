package com.dblws.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        /* 스트림의 병렬 처리에 대해 이해할 수 있다. */
        List<String> list = new ArrayList<>(
                Arrays.asList("java", "mariadb", "html" , "css" , "mybatis")
        );

        System.out.println("for each =================");
        for(String s : list){
            print(s);
        }

        System.out.println("normal stream =================");
        list.stream().forEach(Application2::print);

        // 만약 처리할 데이터가 많을 때, 병렬 스트림을 사용하면 더 데이터를 효율적으로 처리할 수 있음
        // 순차적으로 처리된다는 보장은 없음
        System.out.println("parallel stream =================");
        list.parallelStream().forEach(Application2::print);
        list.parallelStream().forEach(Application2::print);
    }

    private static void print(String str){
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}
