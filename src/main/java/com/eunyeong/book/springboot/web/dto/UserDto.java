package com.eunyeong.book.springboot.web.dto;

import com.eunyeong.book.springboot.domain.user.Role;
import com.eunyeong.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 클라이언트에서 전달하는 데이터를 담는 객체
@Getter
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String picture;
    private Role role;
    private String token;

    @Builder
    public UserDto(String name, String email, String picture, Role role, String token) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role=role;
        this.token = token;
    }

    // Dto 객체를 Entity 객체로 변환해서 반환하는 유틸리티 메서드
    public User toEntity() {
        return User.builder().name(name).email(email).picture(picture).role(role).token(token).build();
    }
}
