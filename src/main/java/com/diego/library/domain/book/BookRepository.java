package com.diego.library.domain.book;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAllByActiveTrue(Pageable paginator);
}
