package com.eunyeong.book.springboot.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 변환
public class HelloController { // GET의 요청을 받을 수 있는 API 생성

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    } // /hello로 요청이 들어오면 문자열 hello를 반환
}
