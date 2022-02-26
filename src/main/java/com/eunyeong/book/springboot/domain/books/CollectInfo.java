package com.eunyeong.book.springboot.domain.books;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class CollectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

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
    private Integer reserveState;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="book_id")
    private Books book;

    @Builder
    public CollectInfo(Books book, String collectLocation, String callNumber, String enrollNum, Integer state, LocalDate returnDate, Integer reserveState){
        this.book = book;
        this.collectLocation = collectLocation;
        this.callNumber = callNumber;
        this.enrollNum = enrollNum;
        this.state = state;
        this.returnDate = returnDate;
        this.reserveState = reserveState;
    }

    public void update(String collectLocation, LocalDate returnDate,Integer state, Integer reserveState){
        this.collectLocation = collectLocation;
        this.state = state;
        this.returnDate = returnDate;
        this.reserveState = reserveState;
    }
}
