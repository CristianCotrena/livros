package com.example.library.service.bookService;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UpdateBookService {
    private BookRepository bookRepository;

    public Mono<Book> update(String id, Book book) {
        return bookRepository.findById(id)
                .flatMap(existingBook -> {
                    if (book.getTitle() != null) {
                        existingBook.setTitle(book.getTitle());
                    }
                    if (book.getGenre() != null) {
                        existingBook.setGenre(book.getGenre());
                    }
                    if (book.getYear() != null) {
                        existingBook.setYear(book.getYear());
                    }
                    if (book.getEdition() != null) {
                        existingBook.setEdition(book.getEdition());
                    }
                    if (book.getPageNumber() != null) {
                        existingBook.setPageNumber(book.getPageNumber());
                    }
                    if (book.getAuthor() != null) {
                        existingBook.setAuthor(book.getAuthor());
                    }
                    if (book.getPublisher() != null) {
                        existingBook.setPublisher(book.getPublisher());
                    }
                    if (book.getIsbn() != null) {
                        existingBook.setIsbn(book.getIsbn());
                    }

                    return bookRepository.save(existingBook);
                });
    }
}
