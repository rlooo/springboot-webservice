package com.eunyeong.book.springboot.domain.books;

import com.eunyeong.book.springboot.domain.BaseTimeEntity;
import com.eunyeong.book.springboot.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="books") // 엔티티와 관련을 맺고 있는 테이블이 books 테이블이라고 명시
public class Books extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String thumbnail;

    @Column
    private String type;

    @Column
    private String author;

    @Column
    private String sign;

    @Column
    private String publish;

    @Column
    private String shape;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true)
    private List<CollectInfo> collectInfoList = new ArrayList<>();

    @Builder
    public Books(String title, String thumbnail, String type, String author, String sign, String publish, String shape, List<CollectInfo> collectInfoList){
        this.title = title;
        this.thumbnail = thumbnail;
        this.type = type;
        this.author = author;
        this.sign = sign;
        this.publish = publish;
        this.shape = shape;
        this.collectInfoList = collectInfoList;
    }

    public void update(String title, String thumbnail, String type, String author, String sign, String publish, String shape){
        this.title = title;
        this.thumbnail = thumbnail;
        this.type = type;
        this.author = author;
        this.sign = sign;
        this.publish = publish;
        this.shape = shape;
    }
}
