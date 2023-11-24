package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.dto.CreateBookDto;
import com.example.library.service.bookService.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private CreateBookService createBookService;
    private UpdateBookService updateBookService;
    private SearchBookService searchBookService;
    private ListBookService listBookService;
    private ListByIdBookService listByIdBookService;

    private DeleteBookService deleteBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> save(@Valid @RequestBody CreateBookDto bookDto) {
        return createBookService.save(bookDto);
    }

    @PatchMapping("/{id}")
    public Mono<Book> update(@PathVariable String id, @RequestBody Book book) {
        return updateBookService.update(id, book);
    }

    @GetMapping("/{id}")
    public Mono<Book> search(@PathVariable String id){
        return searchBookService.searchBookId(id);
    }

    @GetMapping("/list")
    public Flux<Book> list(){
        return listBookService.listBook();
    }

    public Flux<Book> listByIdAndYear(
            @RequestParam(required = false)Integer year,
            @RequestParam(required = false)String genre){

        return listByIdBookService.ListBookYearAndGenre(year,genre);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deletar(@PathVariable String id) {
        return deleteBookService.deleteById(id);
    }
}
