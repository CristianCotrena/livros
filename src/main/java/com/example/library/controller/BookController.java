package com.example.library.controller;

import com.example.library.dto.CreateBookDto;
import com.example.library.service.bookService.CreateBookService;
import com.example.library.service.bookService.DeleteBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private CreateBookService createBookService;

    @Autowired
    private DeleteBookService deleteBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> save(@Valid @RequestBody CreateBookDto bookDto) {
        return createBookService.save(bookDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deletar(@PathVariable String id) {
        return deleteBookService.deleteById(id);
    }
}
