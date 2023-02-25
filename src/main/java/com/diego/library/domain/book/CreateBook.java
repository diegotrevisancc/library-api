package com.diego.library.domain.book;

import jakarta.validation.constraints.NotNull;

public record CreateBook(
        @NotNull
        String title,
        @NotNull
        String author,
        @NotNull
        Genre genre,
        @NotNull
        String length) {
}
