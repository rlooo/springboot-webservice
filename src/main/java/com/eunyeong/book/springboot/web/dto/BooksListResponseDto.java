package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.domain.books.CollectInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BooksListResponseDto {
    private Long id;
    private String title;
    private String thumbnail;
    private String author;
    private String type;
    private String sign;
    private String publish;
    private String shape;
    private List<CollectInfo> collectInfoList;

    public BooksListResponseDto(Books entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.thumbnail = entity.getThumbnail();
        this.author = entity.getAuthor();
        this.type = entity.getType();
        this.sign = entity.getSign();
        this.publish = entity.getPublish();
        this.shape = entity.getShape();
        this.collectInfoList = entity.getCollectInfoList();

    }
}
