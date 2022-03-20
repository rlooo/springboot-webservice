//package com.eunyeong.book.springboot.domain.books;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@NoArgsConstructor
//@Entity
//@Table(name="reserve")
//public class Reserve {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserve", orphanRemoval = true)
//    private List<Books> loan_statue = new ArrayList<>();
//
//    @Column
//    private LocalDate reserveDate;
//
//    @Column
//    private LocalDate arrivalNotice;
//
//    @Column
//    private LocalDate LoanWaiting;
//
//    @Column
//    private Integer ranking;
//
//    @Column
//    private Integer status;
//
//    @Column
//    private Integer cancel;
//
//}