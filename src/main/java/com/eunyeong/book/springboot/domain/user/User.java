package com.eunyeong.book.springboot.domain.user;

import com.eunyeong.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="User")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "token", columnDefinition = "TEXT")
    private String token;

    @Builder
    public User(String name, String email, String picture, Role role, String token){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
        this.token=token;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture= picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

