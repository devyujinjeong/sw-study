package com.dbwls.section01.list.run;

import java.util.LinkedList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        /* LinkedList */
        List<String> linkedList = new LinkedList<>();

        /* 내부적인 구현 코드는 다르지만 LinkedList도 List 계열이기 때문에
        * 동일한 메소드를 호출해서 작업할 수 있다. */
        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("orange");
        linkedList.add("banana");

        for(int i=0; i<linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }

        /* List 계열에 정의된 모든 메소드를 ArrayList와 동일하게 사용할 수 있다. */
        System.out.println(linkedList.isEmpty());
        linkedList.clear();
        System.out.println(linkedList.isEmpty());

        /* LinkedList는 ArrayList와 내부적인 구현 방식이 다르므로
        * 수정, 삭제가 빈번한 상황에서는 LinkedList를 사용하는 것이 효율적이다. */
    }
}
