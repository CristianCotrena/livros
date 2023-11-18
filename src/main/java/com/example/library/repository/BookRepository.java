package com.example.library.repository;

import com.example.library.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveMongoRepository<Book,String> {

    Mono<Book> findByIsbn(String isbn);

    Mono<Book> findById(String id);

}
