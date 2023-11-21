package com.example.library.service.bookService;

import com.example.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteBookService {
    @Autowired
    private BookRepository bookRepository;

    public Mono<Void> deleteById(String id) {
        return bookRepository.existsById(id).flatMap(existingBook -> {
            if (!existingBook) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado.");
            }
            return bookRepository.deleteById(id);
        });
    }
}
