package com.eunyeong.book.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CollectInfoResponseDto {
    private Long book;
    private String collectLocation;
    private String callNumber;
    private String enrollNum;
    private Integer state;
    private LocalDate returnDate;
    private Integer reserveState;

}
