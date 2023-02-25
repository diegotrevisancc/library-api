package com.diego.library.domain.reader;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
  Page<Reader> findAllByActiveTrue(Pageable paginator);
}
