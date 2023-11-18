package com.example.library.domain;

import com.example.library.dto.CreateBookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book {

    @Id
    private String id;
    private String title;
    private String genre; // possível mudança: vários generos
    private Integer year;
    private String edition;
    private Integer pageNumber;
    private String author; // possível mudança: diversos autores
    private String publisher;
    private String isbn; // cada livro tem um único isbn

    public Book(CreateBookDto bookDto){
        this.title = bookDto.getTitle();
        this.genre = bookDto.getGenre();
        this.year = bookDto.getYear();
        this.edition = bookDto.getEdition();
        this.pageNumber = bookDto.getPageNumber();
        this.author = bookDto.getAuthor();
        this.publisher = bookDto.getPublisher();
        this.isbn = bookDto.getIsbn();
    }

}
