package com.example.library.service.bookService;

import com.example.library.domain.Book;
import com.example.library.dto.CreateBookDto;
import com.example.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateBookService {
    private BookRepository bookRepository;

    //I couldn't check if the book was already on the database using Mono<Book> so I worked that around using Mono<Object>.
    public Mono<Object> save(CreateBookDto bookDto) {
        return bookRepository.findByIsbn(bookDto.getIsbn())
                .flatMap(existingBook -> Mono.error(new RuntimeException("Book already exists")))
                .switchIfEmpty(bookRepository.save(new Book(bookDto)));

    }

}
