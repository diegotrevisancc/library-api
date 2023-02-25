package com.diego.library.domain.book;

public record BookDetails(Long id, String title, String author, Genre genre, String length) {
    public BookDetails(Book book) {
        this(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getLength());
    }

}
