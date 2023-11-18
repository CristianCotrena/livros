package com.example.library.dto;

import com.example.library.domain.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBookDto {
    @NotBlank
    private String title;
    @NotBlank
    private String genre;
    @NotNull
    private Integer year;
    @NotBlank
    private String edition;
    @NotNull
    private Integer pageNumber;
    @NotBlank
    private String author;
    @NotBlank
    private String publisher;
    @NotNull
    private String isbn;
}
