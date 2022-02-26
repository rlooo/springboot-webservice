package com.eunyeong.book.springboot.domain.books;

import com.eunyeong.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectInfoRepository extends JpaRepository<CollectInfo, Long> {
    @Query("SELECT p FROM CollectInfo p ORDER BY p.seq DESC")
    List<CollectInfo> findAllDesc();
}
