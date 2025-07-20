package com.dbwls.section03.map;

import java.util.HashMap;

public class UsingHashMap {
    public static void main(String[] args) {
        /* 1. 문자열 타입을 키, 값으로 하는 HashMap */
        HashMap<String, String> hmap = new HashMap<>();

        // 2. put 메소드를 이용해 entry 넣기
        hmap.put("one", "java");
        hmap.put("two", "mysql");

        // 3. get과 getOrDefault 이용해 값 가져오기.
        System.out.println(hmap.get("one")); // java 출력
        System.out.println(hmap.getOrDefault("two","no")); // mysql 출력
        System.out.println(hmap.getOrDefault("three","no")); // no 출력

        // 4. containsKey와 containsValue를 이용해 값의 존재 유무 파악
        System.out.println(hmap.containsKey("one")); // true
        System.out.println(hmap.containsKey("three")); // false
        System.out.println(hmap.containsValue("java")); // true
        System.out.println(hmap.containsValue("jdbc")); // false

        // 5. replace를 이용해 값 바꾸기
        hmap.replace("one","jdbc"); // value값이 jdbc로 변경
        hmap.replace("two","mysql","html"); // value값이 html로 변경
        hmap.replace("two","css","html"); // value값이 변경되지 않음


        // 6. entrySet으로 set값으로 값을 가져오기
        System.out.println(hmap.entrySet()); // 가져올 때, {}에서 []로 출력

        // 7. isEmpty()로 값이 비어있는지 확인
        System.out.println(hmap.isEmpty()); // false 출력

        // 8. remove와 clear로 값 삭제하기
        System.out.println(hmap.remove("one")); // 해당하는 entry가 삭제됨
        hmap.clear(); // 모든 entry가 삭제됨
        System.out.println(hmap.isEmpty()); // true

    }
}
