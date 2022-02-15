package com.eunyeong.book.springboot.domain.books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectInfoRepository extends JpaRepository<Books, Long> {
}
