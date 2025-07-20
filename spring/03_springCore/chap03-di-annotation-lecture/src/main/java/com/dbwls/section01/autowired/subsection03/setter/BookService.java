package com.dbwls.section01.autowired.subsection03.setter;

import com.dbwls.section01.autowired.common.BookDAO;
import com.dbwls.section01.autowired.common.BookDTO;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* component scan을 통해 bean 등록, bookServiceConstructor 가 bean name */
@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    /* 의존성 주입이 옵션으로 수행 될 수 있도록 처리하는데 유용하게 사용됨*/
    @Autowired(required = false) // setter 주입
    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}