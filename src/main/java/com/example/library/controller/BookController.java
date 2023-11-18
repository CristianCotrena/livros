package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.dto.CreateBookDto;
import com.example.library.service.bookService.CreateBookService;
import com.example.library.service.bookService.ListBookService;
import com.example.library.service.bookService.SearchBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private CreateBookService createBookService;
    private SearchBookService searchBookService;
    private ListBookService listBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> save(@Valid @RequestBody CreateBookDto bookDto) {
        return createBookService.save(bookDto);
    }

    @GetMapping("/{id}")
    public Mono<Book> search(@PathVariable String id){
        return searchBookService.searchBookId(id);
    }

    @GetMapping("/list")
    public Flux<Book> list(){
        return listBookService.listBook();
    }
}
