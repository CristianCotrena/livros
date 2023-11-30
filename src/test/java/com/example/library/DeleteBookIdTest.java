package com.example.library;

import com.example.library.config.BaseTest;
import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.*;

public class DeleteBookIdTest extends BaseTest {
    @Autowired
    private WebClient webClient;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void deleteTest() {
        when(bookRepository.existsById("10")).thenReturn(Mono.just(true));
        when(bookRepository.deleteById("10")).thenReturn(Mono.justOrEmpty(null));


        Mono<Book> response = this.webClient
                .delete()
                .uri("/books/{id}", 10)
                .retrieve()
                .bodyToMono(Book.class);

        StepVerifier.create(response)
                .verifyComplete();
    }

    @Test
    public void deleteErrorTest() {
        when(bookRepository.existsById("10")).thenReturn(Mono.just(false));
        when(bookRepository.deleteById("10")).thenReturn(Mono.justOrEmpty(null));


        Mono<Book> response = this.webClient
                .delete()
                .uri("/books/{id}", 10)
                .retrieve()
                .bodyToMono(Book.class);

        StepVerifier.create(response).expectError();
    }
}
