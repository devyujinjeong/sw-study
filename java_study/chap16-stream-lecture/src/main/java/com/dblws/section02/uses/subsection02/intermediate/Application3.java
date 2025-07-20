package com.dblws.section02.uses.subsection02.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {
        /* 스트림의 중계 연산 중 하나인 flatMap 에 대해 이해하고 사용할 수 있다.
         * flatMap : 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어준다. (플래트닝)
         * */
        List<List<String>> list = Arrays.asList(
                Arrays.asList("Java", "Spring", "SpringBoot"),
                Arrays.asList("JAVA", "SPRING", "SPRINGBOOT")
        );

        System.out.println(list);

        List<String> flatList = list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(flatList);

        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java Stream API",
                "flatMap Example"
        );

        System.out.println(sentences);

        // 단어로 분리해서 list 만들기
        List<String> words = sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .toList();

        System.out.println(words);

//        words.add("단어 추가");

        /* Unmodifiable List (수정 불가 읽기 전용 리스트 - 불변성 보장) */
        List<String> unmodifiableList1 = Collections.unmodifiableList(flatList);
        List<String> unmodifiableList2 = List.of("A", "B", "C");
        List<String> unmodifiableList3 = Stream.of("A", "B", "C").toList();

    }
}
