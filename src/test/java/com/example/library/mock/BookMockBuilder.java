package com.example.library.mock;

import com.example.library.domain.Book;

public class BookMockBuilder {
    public static Book build() {
        return Book.builder()
                .id("10")
                .author("Herman")
                .edition("-")
                .genre("Spirit")
                .pageNumber(762)
                .year(1300)
                .title("Codex Gigas")
                .build();
    }
}
