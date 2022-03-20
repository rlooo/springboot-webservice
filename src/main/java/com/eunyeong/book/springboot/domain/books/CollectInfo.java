package com.eunyeong.book.springboot.domain.books;

import com.eunyeong.book.springboot.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name="collectinfo")
public class CollectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

//    @Column
//    private String collectLocation;
    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="collect_location")
    private Category collectLocation;

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

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="book_id")
    private Books book;

//대출 관련 컬럼
    @Column
    private LocalDate loanDate;

    @Column
    private Integer extensionCount;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @Builder
    public CollectInfo(Books book, Category collectLocation, String callNumber, String enrollNum, Integer state, LocalDate returnDate, LocalDate loanDate, Integer extensionCount, Integer reserveState,User user){
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

    public void update(Integer state, LocalDate returnDate, Integer reserveState, Integer extensionCount, User user){
        //this.collectLocation = collectLocation;
        this.state = state;
        this.returnDate = returnDate;
        this.reserveState = reserveState;
        this.extensionCount=extensionCount;
        this.user=user;
    }
}
