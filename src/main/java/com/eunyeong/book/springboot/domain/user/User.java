package com.eunyeong.book.springboot.domain.user;

import com.eunyeong.book.springboot.domain.BaseTimeEntity;
import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.domain.books.CollectInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;

    @Column(name = "accessToken", columnDefinition = "TEXT")
    private String accessToken;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<CollectInfo> collectInfoList = new ArrayList<>();

    @Builder
    public User(String name, String email, String picture, String accessToken){
        this.name=name;
        this.email=email;
        this.picture=picture;
//        this.role=role;
        this.accessToken=accessToken;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture= picture;

        return this;
    }

//    public String getRoleKey() {
//        return this.role.getKey();
//    }

}


