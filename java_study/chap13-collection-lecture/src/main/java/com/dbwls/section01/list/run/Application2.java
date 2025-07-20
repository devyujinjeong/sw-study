package com.dbwls.section01.list.run;

import com.dbwls.section01.list.comparator.AscendingPrice;
import com.dbwls.section01.list.dto.BookDTO;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {

        /* 사용자 정의 자료형으로 ArrayList 생성하고 정렬하기*/
        List<BookDTO> bookList = new ArrayList<>();

        /* 도서 정보 추가 */
        bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
        bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000));
        bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));

        for(BookDTO book : bookList) {
            System.out.println(book);
        }

        /* implements Comparable를 통해 comparTo 메소드(정렬 기준 반환)가 재정의 되어야한
        * 사용 가능한데 현재는 정의 되어 있지 않다. */

        /* 도서 제목 오름차순 */
        Collections.sort(bookList);
        System.out.println("도서 제목 오름차순 : " + bookList);

        /* Comparator 인터페이스를 구현한 정렬 기준을 사용한다. */
        Collections.sort(bookList, new AscendingPrice());
        System.out.println("가격 오름차순 : " + bookList);

        /* 정렬 기준을 계속해서 사용하는 경우 별도의 클래스를 선언해도 되지만
        * 한 번만 사용할 경우 더 간편하게 익명 클래스(Anonymous Class)를 활용할 수도 있다.
        * */

        // 굳이 다시 쓸 일이 없기 때문에 클래스로 꼭 구현해서 쓰지 않고 익명으로 구현해서 사용할 수 있다.
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                // 기준이 여러개 일수는 없다.
                return o2.getPrice() - o1.getPrice();
            }
        });

    }
}
