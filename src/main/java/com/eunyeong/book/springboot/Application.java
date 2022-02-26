package com.eunyeong.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Application: 앞으로 만들 프로젝트의 메인 클래스
@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 자동 설정
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); // 내장 WAS 실행
    }
}