package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.domain.books.CollectInfo;
import com.eunyeong.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BooksSaveRequestDto {
    private Long id;
    private String title;
    private String thumbnail;
    private String type;
    private String author;
    private String sign;
    private String publish;
    private String shape;
    private List<CollectInfo> collectInfoList;

    @Builder
    public BooksSaveRequestDto(String title, String thumbnail, String type, String author, String sign, String publish, String shape) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.type = type;
        this.author = author;
        this.sign = sign;
        this.publish = publish;
        this.shape = shape;
    }

    public Books toEntity() {
        return Books.builder()
                .title(title)
                .thumbnail(thumbnail)
                .type(type)
                .author(author)
                .sign(sign)
                .publish(publish)
                .shape(shape)
                .build();
    }
}
