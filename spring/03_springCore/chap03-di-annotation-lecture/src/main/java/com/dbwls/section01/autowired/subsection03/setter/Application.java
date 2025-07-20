package com.dbwls.section01.autowired.subsection03.setter;

import com.dbwls.section01.autowired.common.BookDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.dbwls.section01");

        BookService bookService
                = applicationContext.getBean("bookServiceSetter", BookService.class);
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.selectAllBooks());


    }
}