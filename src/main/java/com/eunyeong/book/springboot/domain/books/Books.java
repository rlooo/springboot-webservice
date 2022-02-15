package com.eunyeong.book.springboot.domain.books;

import com.eunyeong.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Books extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String thumbnail;

    @Column
    private String author;

    @Column
    private String sign;

    @Column
    private String publish;

    @Column
    private String shape;

    @Builder
    public Books(String title, String thumbnail, String author, String sign, String publish, String shape){
        this.title = title;
        this.thumbnail = thumbnail;
        this.author = author;
        this.sign = sign;
        this.publish = publish;
        this.shape = shape;
    }

    public void update(String title, String thumbnail, String author, String sign, String publish, String shape){
        this.title = title;
        this.thumbnail = thumbnail;
        this.author = author;
        this.sign = sign;
        this.publish = publish;
        this.shape = shape;
    }
}
