package com.dblws.section02.uses;

import java.util.stream.Stream;

public class practice {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(10, x -> x * 2).limit(10);

        stream.forEach(val -> System.out.print(val + " "));
    }
}
