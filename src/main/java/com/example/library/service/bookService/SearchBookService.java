package com.example.library.service.bookService;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
public class SearchBookService {

    @Autowired
    private BookRepository bookRepository;

    public Mono<Book> searchBookId(String id) {
        if (id == null) {
            return Mono.error(new IllegalArgumentException("ID não pode ser nulo"));
        } else {
            return bookRepository.findById(id)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado com o ID " + id)));

        }
    }
}





