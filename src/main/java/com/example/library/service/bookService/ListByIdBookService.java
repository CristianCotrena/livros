package com.example.library.service.bookService;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;

@Service
public class ListByIdBookService {

    @Autowired
    private BookRepository bookRepository;


    public Flux<Book> ListBookYearAndGenre(Integer year, String genre) {
        if (year == null && genre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "É necessário passar o Ano ou o Genero");
        }

        if (year != null && genre != null) {
            return bookRepository.findByYearAndGenre(year, genre);
        } else if (year != null) {
            return bookRepository.findByYear(year);
        } else if (genre != null) {
            return bookRepository.findByGenre(genre);

        }
        return Flux.empty();
    }

}



