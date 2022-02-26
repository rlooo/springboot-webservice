package com.eunyeong.book.springboot.domain.posts;

import com.eunyeong.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pK 생성 규칙을 나타냄.
    //@Field("id")
    // GenerationType.IDENTITY 옵션: auto_increment
    private Long id;

    @Column(length = 500, nullable = false)
    //@Field("title")
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    //@Field("content")
    private String content;

    @Column
    //@Field("author")
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
