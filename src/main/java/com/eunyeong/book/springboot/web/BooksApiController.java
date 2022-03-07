package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.service.books.BooksService;
import com.eunyeong.book.springboot.web.dto.BooksSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.CollectInfoResponseDto;
import com.eunyeong.book.springboot.web.dto.CollectInfoSaveRequestDto;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BooksApiController {

    @Autowired
    private final BooksService booksService;

    @PostMapping("/books/save")
    @ResponseBody
    public void booksSave(@RequestBody BooksSaveRequestDto bookRequestDto){
        booksService.saveBooks(bookRequestDto);
    }

    @PostMapping("/collectinfo/save")
    @ResponseBody
    public Long collectInfoSave(@RequestBody CollectInfoResponseDto collectInfoResponseDto) {
        Books book=booksService.searchBooks2(collectInfoResponseDto.getBook());
        CollectInfoSaveRequestDto collectInfoSaveRequestDto = new CollectInfoSaveRequestDto();
        collectInfoSaveRequestDto.setBook(book);
        BeanUtils.copyProperties(collectInfoResponseDto, collectInfoSaveRequestDto); // 주입된 Bean을 또다른 객체의 Bean으로 복사시 사용
        return booksService.saveCollectInfo(collectInfoSaveRequestDto);
    }

    @GetMapping("/book/search")
    @ResponseBody
    public Map<String, Object> search(@RequestBody HashMap<String, Object> param) {

        String keyword=param.get("keyword").toString();

        Map<String, Object> map = new HashMap<>();

        map.put("bookList", booksService.searchBooks(keyword));
        return map;
    }



}


