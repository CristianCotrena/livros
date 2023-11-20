package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.dto.CreateBookDto;
import com.example.library.service.bookService.CreateBookService;
import com.example.library.service.bookService.UpdateBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private CreateBookService createBookService;
    private UpdateBookService updateBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> save(@Valid @RequestBody CreateBookDto bookDto) {
        return createBookService.save(bookDto);
    }

    @PatchMapping("/{id}")
    public Mono<Book> update(@PathVariable String id, @RequestBody Book book) {
        return updateBookService.update(id, book);
    }

}
