package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 변환
public class HelloController { // GET의 요청을 받을 수 있는 API 생성

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    } // /hello로 요청이 들어오면 문자열 hello를 반환

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        //RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        return new HelloResponseDto(name, amount);
    }
}
