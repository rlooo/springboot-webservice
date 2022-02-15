package com.eunyeong.book.springboot.domain.books;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;

public class CollectInfo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne(targetEntity= Books.class, fetch= FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Books book;

    @Column
    private String collectLocation;

    @Column
    private String callNumber;

    @Column
    private String enrollNum;

    @Column
    private Integer state;

    @Column
    private LocalDate returnDate;

    @Column
    private String reserveState;

    @Builder
    public CollectInfo(Books book, String collectLocation, String callNumber, String enrollNum, Integer state, LocalDate returnDate, String reserveState){
        this.book = book;
        this.collectLocation = collectLocation;
        this.callNumber = callNumber;
        this.enrollNum = enrollNum;
        this.state = state;
        this.returnDate = returnDate;
        this.reserveState = reserveState;
    }

    public void update(String collectLocation, LocalDate returnDate,Integer state, String reserveState){
        this.collectLocation = collectLocation;
        this.state = state;
        this.returnDate = returnDate;
        this.reserveState = reserveState;
    }
}
