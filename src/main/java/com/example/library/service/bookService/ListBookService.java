package com.example.library.service.bookService;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListBookService {

    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> listBook() {
        return bookRepository.findAll();
    }
}
