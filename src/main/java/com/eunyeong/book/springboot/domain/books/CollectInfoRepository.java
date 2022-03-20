package com.eunyeong.book.springboot.domain.books;

import com.eunyeong.book.springboot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectInfoRepository extends JpaRepository<CollectInfo, Long> {
    @Query("SELECT p FROM CollectInfo p ORDER BY p.seq DESC")
    List<CollectInfo> findAllDesc();

    @Query("SELECT p FROM Books p WHERE p.id=:book_id")
    Books findBookByid(Long book_id);

    @Query("SELECT c FROM CollectInfo c WHERE c.seq=:seq")
    CollectInfo findCollectInfoBySeq(Long seq);

    @Query("SELECT c FROM CollectInfo c WHERE c.user=:user")
    List<CollectInfo> loanStatus(User user);

    @Query("SELECT c FROM CollectInfo c WHERE c.collectLocation=:collectLocation")
    CollectInfo findCollectInfoByCategory(Category collectLocation);
}


