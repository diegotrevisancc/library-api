package com.diego.library.domain.book;

import jakarta.validation.constraints.NotNull;

public record BookChangeData(
        @NotNull
        Long id,
        String title,
        String author,
        Genre genre,
        String length) {
}
