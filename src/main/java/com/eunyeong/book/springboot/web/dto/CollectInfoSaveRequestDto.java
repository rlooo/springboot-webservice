package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.domain.books.CollectInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CollectInfoSaveRequestDto {
    private Books book;
    private String collectLocation;
    private String callNumber;
    private String enrollNum;
    private Integer state;
    private LocalDate returnDate;
    private Integer reserveState;


    @Builder
    public CollectInfoSaveRequestDto(Books book, String collectLocation, String callNumber, String enrollNum, Integer state, LocalDate returnDate, Integer reserveState) {
        this.book = book;
        this.collectLocation = collectLocation;
        this.callNumber = callNumber;
        this.enrollNum = enrollNum;
        this.state = state;
        this.returnDate = returnDate;
        this.reserveState = reserveState;
    }

    @NotNull
    public CollectInfo toEntity() {
        return CollectInfo.builder()
                .book(book)
                .collectLocation(collectLocation)
                .callNumber(callNumber)
                .enrollNum(enrollNum)
                .state(state)
                .returnDate(returnDate)
                .reserveState(reserveState)
                .build();
    }
}
