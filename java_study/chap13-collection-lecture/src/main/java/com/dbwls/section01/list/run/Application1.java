package com.dbwls.section01.list.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Application1 {
    public static void main(String[] args) {
        /* ArraysList
        : 배열은 크기를 변경하는 것이 불가능하고 요소의 추가/삭제/정렬 등이 복잡하다.
        이러한 기능을 메소드로 구현해서 제공하고 있다. 다만, 속도가 빨라지는 것은 아니다. */
        ArrayList alist = new ArrayList<>();

        /* 다형성을 이용해서 상위 레퍼런스로 ArrayList 객체를 참조할 수 있다.
        * List 인터페이스 하위의 다양한 구현체들로 타입 변경이 가능하므로
        * 보다 유연한 코드를 작성할 수 있다. */
        ArrayList<String> slist = new ArrayList<>();

        /* 타입 안전성이 떨어지기 때문에 잘 사용하지 않는다.*/
//        alist.add("hello");
//        alist.add(10);
//        alist.add(new Date());

        /* String 타입만 취급하도록 컴파일러가 체크한다. */
        slist.add("banana");
        slist.add("apple");
//        slist.add(10);
        slist.add("banana");

        /* add 메소드
        * (1) 저장한 순서대로 데이터가 저장 되며
        * (2) 중복 데이터도 저장 된다. */
        System.out.println("slist : " + slist);

        System.out.println("slist.size() : " + slist.size());
        for(int i=0; i<slist.size(); i++){
            System.out.println("slist.get("+i+"): " + slist.get(i));
        }

        /* 요소 정렬 */
        Collections.sort(slist);
        System.out.println(slist);
    }
}
