package com.example.library.repository;

import com.example.library.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveMongoRepository<Book,String> {

    Mono<Book> findByIsbn(String isbn);

    Mono<Book> findById(String id);

    Flux<Book> findByYearAndGenre(Integer year, String genre);

    Flux<Book> findByYear(Integer year);

    Flux<Book> findByGenre(String genre);


}
