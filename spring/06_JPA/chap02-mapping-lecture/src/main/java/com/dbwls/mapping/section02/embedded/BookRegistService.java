package com.dbwls.mapping.section02.embedded;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;        Book book = new Book(
        newBook.getBookTitle(),
        newBook.getAuthor(),
        newBook.getPublisher(),
        newBook.getPublishedDate(),
        new Price(
                newBook.getRegularPrice(),
                newBook.getDiscountRate()
        )
);

@Service
public class BookRegistService {

    private BookRepository bookRepository;

    public BookRegistService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void registBook(BookRegistDTO newBook){


        bookRepository.save(book);
    }
}
