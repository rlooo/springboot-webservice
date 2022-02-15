package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.books.Books;

public class BooksListResponseDto {
    private Long id;
    private String title;
    private String thumbnail;
    private String author;
    private String sign;
    private String publish;
    private String shape;

    public BooksListResponseDto(Books entity) {
        this.title = entity.getTitle();
        this.thumbnail = entity.getThumbnail();
        this.author = entity.getAuthor();
        this.sign = entity.getSign();
        this.publish = entity.getPublish();
        this.shape = entity.getShape();
    }
}
