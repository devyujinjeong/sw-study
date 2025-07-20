package com.dbwls.section01.autowired.subsection02.constructor;

import com.dbwls.section01.autowired.common.BookDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.dbwls.section01");

        // bookServiceConstructor라는 이름의 bean 객체를 가져오기
        // 이 때, 이 bean 객체에는 생성자 주입을 통해 의존성 주입이 됐다. (BookDAO가 주입)
        BookService bookService
                = applicationContext.getBean("bookServiceConstructor", BookService.class);
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.selectAllBooks());

        /* IoC 컨테이너 없이 코드를 테스트 할 대 생성자를 통해 BookDAO() 객체를 전달해 처리 가능 */
        BookService bookService2 = new BookService(new BookDAOImpl());
        System.out.println(bookService2.selectAllBooks());

    }
}