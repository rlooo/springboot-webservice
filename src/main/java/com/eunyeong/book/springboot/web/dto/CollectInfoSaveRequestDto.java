package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.domain.books.CollectInfo;
import com.eunyeong.book.springboot.domain.books.Category;
import com.eunyeong.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CollectInfoSaveRequestDto {
    private LocalDate loanDate;
    private User user;
    private Integer extensionCount;
    private Books book;
    private Category collectLocation;
    private String callNumber;
    private String enrollNum;
    private Integer state;
    private LocalDate returnDate;
    private Integer reserveState;


    @Builder
    public CollectInfoSaveRequestDto(Books book, Category collectLocation, String callNumber, String enrollNum, Integer state, LocalDate returnDate, LocalDate loanDate, Integer extensionCount, Integer reserveState,User user) {
        this.book = book;
        this.collectLocation = collectLocation;
        this.callNumber = callNumber;
        this.enrollNum = enrollNum;
        this.state = state;
        this.returnDate = returnDate;
        this.reserveState = reserveState;
        this.loanDate=loanDate;
        this.extensionCount=extensionCount;
        this.user=user;
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
                .loanDate(loanDate)
                .extensionCount(extensionCount)
                .user(user)
                .build();
    }
}
