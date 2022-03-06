package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.service.books.BooksService;
import com.eunyeong.book.springboot.web.dto.BooksSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.CollectInfoResponseDto;
import com.eunyeong.book.springboot.web.dto.CollectInfoSaveRequestDto;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BooksApiController {
    private final BooksService booksService;

    @PostMapping("/books/save")
    @ResponseBody
    public void booksSave(@RequestBody BooksSaveRequestDto bookRequestDto){
        booksService.save(bookRequestDto);
    }

    @PostMapping("/collectinfo/save")
    @ResponseBody
    public Long collectInfoSave(@RequestBody CollectInfoResponseDto collectInfoResponseDto) {
        Books book=booksService.searchBooks2(collectInfoResponseDto.getBook());
        CollectInfoSaveRequestDto collectInfoSaveRequestDto = null;
        collectInfoSaveRequestDto.setBook(book);
        return booksService.save(collectInfoSaveRequestDto);
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


