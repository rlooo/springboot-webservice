package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CollectInfoUpdateRequestDto {

    private LocalDate loanDate;
    private User user;
    //private String collectLocation;
    private Integer state;
    private LocalDate returnDate;
    private Integer reserveState;
    private Integer extensionCount;

    @Builder
    public CollectInfoUpdateRequestDto(Integer state, LocalDate returnDate, LocalDate loanDate, Integer reserveState, Integer extensionCount, User user){
        //this.collectLocation=collectLocation;
        this.state=state;
        this.returnDate=returnDate;
        this.reserveState=reserveState;
        this.extensionCount=extensionCount;
        this.loanDate=loanDate;
        this.user=user;
    }
}
