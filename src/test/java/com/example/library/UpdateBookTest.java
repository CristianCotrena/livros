package com.example.library;

import com.example.library.config.BaseTest;
import com.example.library.domain.Book;
import com.example.library.mock.BookMockBuilder;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

public class UpdateBookTest extends BaseTest {
    @Autowired
    private WebClient webClient;

    @MockBean
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        book = BookMockBuilder.build();
    }

    @Test
    public void updateTest() {
        when(bookRepository.findById(book.getId())).thenReturn(Mono.just(book));
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> {
            Book updatedBook = invocation.getArgument(0);
            return Mono.just(updatedBook);
        });

        Mono<Book> response = this.webClient
                .patch()
                .uri("/books/{id}", book.getId())
                .bodyValue(book)
                .retrieve()
                .bodyToMono(Book.class);

        StepVerifier.create(response)
                .expectNext(book)
                .verifyComplete();
    }

    @Test
    public void updateErrorTest() {
        when(bookRepository.findById(book.getId())).thenReturn(Mono.empty());

        Mono<Book> response = this.webClient
                .patch()
                .uri("/books/{id}", book.getId())
                .bodyValue(book)
                .retrieve()
                .bodyToMono(Book.class);

        StepVerifier.create(response).expectError();
    }
}
