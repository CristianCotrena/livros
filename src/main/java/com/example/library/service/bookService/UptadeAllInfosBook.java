package com.example.library.service.bookService;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UptadeAllInfosBook {
    private final BookRepository bookRepository;
    public Mono<Book> updateAll(String id, Book updatedBook) {
        return bookRepository.findById(id)
                .flatMap(existingBook -> {
                    existingBook.setTitle(updatedBook.getTitle());
                    existingBook.setGenre(updatedBook.getGenre());
                    existingBook.setYear(updatedBook.getYear());
                    existingBook.setEdition(updatedBook.getEdition());
                    existingBook.setPageNumber(updatedBook.getPageNumber());
                    existingBook.setAuthor(updatedBook.getAuthor());
                    existingBook.setPublisher(updatedBook.getPublisher());
                    existingBook.setIsbn(updatedBook.getIsbn());

                    return bookRepository.save(existingBook);
                });
    }
}
