package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.domain.books.CollectInfo;
import com.eunyeong.book.springboot.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CollectInfoListResponseDto {
    private Long book;
    private Long collectLocation;
    private String callNumber;
    private String enrollNum;
    private Integer state;
    private LocalDate returnDate;
    private Integer reserveState;
    private LocalDate loanDate;
    private Integer extensionCount;
    private Long user;

    public CollectInfoListResponseDto(CollectInfo entity) {
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
}
